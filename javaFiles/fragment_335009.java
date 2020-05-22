import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PuzzleGame extends Application {

    private Image image = new Image("http://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/ferrari-laferrari-zfye-059_1.jpg?itok=hfLNxUD9",600,600,false,true);

    private static double SCENE_WIDTH = 1024;
    private static double SCENE_HEIGHT = 768;

    public static int TILE_ROW_COUNT = 5;
    public static int TILE_COLUMN_COUNT = 5;
    public static double TILE_SIZE = 120;

    public static double offsetX = (SCENE_WIDTH - TILE_ROW_COUNT * TILE_SIZE) / 2;
    public static double offsetY = (SCENE_HEIGHT - TILE_COLUMN_COUNT * TILE_SIZE) / 2;

    List<Cell> cells = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        // create grid
        for (int x = 0; x < TILE_ROW_COUNT; x++) {
            for (int y = 0; y < TILE_COLUMN_COUNT; y++) {

                // create tile
                ImageView tile = new ImageView(image);
                Rectangle2D rect = new Rectangle2D(TILE_SIZE * x, TILE_SIZE * y, TILE_SIZE, TILE_SIZE);
                tile.setViewport(rect);

                // consider empty cell, let it remain empty
                if (x == (TILE_ROW_COUNT - 1) && y == (TILE_COLUMN_COUNT - 1)) {
                    tile = null;
                }

                cells.add(new Cell(x, y, tile));
            }
        }

        // shuffle cells
        shuffle();

        // create playfield
        Pane pane = new Pane();

        // put tiles on playfield, assign event handler
        for (int i = 0; i < cells.size(); i++) {

            Cell cell = cells.get(i);

            Node imageView = cell.getImageView();

            // consider empty cell
            if (imageView == null)
                continue;

            // click-handler: swap tiles, check if puzzle is solved
            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

                moveCell((Node) mouseEvent.getSource());

            });

            // position images on scene
            imageView.relocate(cell.getLayoutX(), cell.getLayoutY());

            pane.getChildren().add(cell.getImageView());
        }

        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Swap images of cells randomly
     */
    public void shuffle() {

        Random rnd = new Random();

        for (int i = 0; i < 1000; i++) {

            int a = rnd.nextInt(cells.size());
            int b = rnd.nextInt(cells.size());

            if (a == b)
                continue;

            // skip bottom right cell swap, we want the empty cell to remain there
            if( cells.get(a).isEmpty() || cells.get(b).isEmpty())
                continue;

            swap( cells.get(a), cells.get(b));

        }

    }

    public void swap( Cell cellA, Cell cellB) {

        ImageView tmp = cellA.getImageView();
        cellA.setImageView(cellB.getImageView());
        cellB.setImageView(tmp);

    }

    public boolean checkSolved() {

        boolean allSolved = true;

        for (Cell cell : cells) {

            if (!cell.isSolved()) {
                allSolved = false;
                break;
            }
        }

        System.out.println("Solved: " + allSolved);

        return allSolved;
    }

    public void moveCell(Node node) {

        // get current cell using the selected node (imageview)
        Cell currentCell = null;
        for (Cell tmpCell : cells) {
            if (tmpCell.getImageView() == node) {
                currentCell = tmpCell;
                break;
            }
        }

        if (currentCell == null)
            return;

        // get empty cell
        Cell emptyCell = null;

        for (Cell tmpCell : cells) {
            if (tmpCell.isEmpty()) {
                emptyCell = tmpCell;
                break;
            }
        }

        if (emptyCell == null)
            return;

        // check if cells are swappable: neighbor distance either x or y must be 1 for a valid move
        int steps = Math.abs(currentCell.x - emptyCell.x) + Math.abs(currentCell.y - emptyCell.y);
        if (steps != 1)
            return;

        System.out.println("Transition: " + currentCell + " -> " + emptyCell);

        // cells are swappable => create path transition
        Path path = new Path();
        path.getElements().add(new MoveToAbs(currentCell.getImageView(), currentCell.getLayoutX(), currentCell.getLayoutY()));
        path.getElements().add(new LineToAbs(currentCell.getImageView(), emptyCell.getLayoutX(), emptyCell.getLayoutY()));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(100));
        pathTransition.setNode(currentCell.getImageView());
        pathTransition.setPath(path);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);

        final Cell cellA = currentCell;
        final Cell cellB = emptyCell;
        pathTransition.setOnFinished(actionEvent -> {

            swap( cellA, cellB);

            checkSolved();

        });

        pathTransition.play();

    }

    private static class Cell {

        int x;
        int y;

        ImageView initialImageView;
        ImageView currentImageView;

        public Cell(int x, int y, ImageView initialImageView) {
            super();
            this.x = x;
            this.y = y;
            this.initialImageView = initialImageView;
            this.currentImageView = initialImageView;
        }

        public double getLayoutX() {
            return x * TILE_SIZE + offsetX;
        }

        public double getLayoutY() {
            return y * TILE_SIZE + offsetY;
        }

        public ImageView getImageView() {
            return currentImageView;
        }

        public void setImageView(ImageView imageView) {
            this.currentImageView = imageView;
        }

        public boolean isEmpty() {
            return currentImageView == null;
        }

        public boolean isSolved() {
            return this.initialImageView == currentImageView;
        }

        public String toString() {
            return "[" + x + "," + y + "]";
        }

    }

    // absolute (layoutX/Y) transitions using the pathtransition for MoveTo
    public static class MoveToAbs extends MoveTo {

        public MoveToAbs(Node node) {
            super(node.getLayoutBounds().getWidth() / 2, node.getLayoutBounds().getHeight() / 2);
        }

        public MoveToAbs(Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    // absolute (layoutX/Y) transitions using the pathtransition for LineTo
    public static class LineToAbs extends LineTo {

        public LineToAbs(Node node, double x, double y) {
            super(x - node.getLayoutX() + node.getLayoutBounds().getWidth() / 2, y - node.getLayoutY() + node.getLayoutBounds().getHeight() / 2);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}