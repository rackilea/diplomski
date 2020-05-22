import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private static final double CELL_HEIGHT = 60;
    private static final double CELL_WIDTH = 100;
    private static final double CELL_H_GAP = 10;
    private static final double CELL_V_GAP = 10;
    private static final int ITEM_COUNT = 100;

    private Pagination pagination;
    private int itemCount; // Count of items that fit on a page

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();

        pagination = new Pagination();
        pagination.setPageFactory(this::pageFactory);

        root.getChildren().add(pagination);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private StackPane pageFactory( int pageIndex ) {
        TilePane page = new TilePane();
        StackPane pageContainer = new StackPane(page);
        pageContainer.setAlignment(Pos.CENTER);

        initPage(page);
        addListeners(pageContainer, page);
        fillPage(page, pageIndex);

        return pageContainer;
    }

    private void initPage( TilePane page ) {
        page.setHgap(CELL_H_GAP);
        page.setVgap(CELL_V_GAP);
        page.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
    }

    private void addListeners ( StackPane pageContainer, TilePane page) {
        pageContainer.heightProperty().addListener( observable -> {
            if (pageContainer.getWidth() != 0 && pageContainer.getHeight() != 0) {
                onResize(pageContainer, page);
            }
        });
        pageContainer.widthProperty().addListener( observable -> {
            if (pageContainer.getWidth() != 0 && pageContainer.getHeight() != 0) {
                onResize(pageContainer, page);
            }
        });
    }

    private void onResize ( StackPane pageContainer, TilePane page ) {
        int itemCountHorizontal = 1;
        int itemCountVertical = 1;
        int itemCount;
        int pageCount;

        itemCountHorizontal += ( pageContainer.getWidth() - CELL_WIDTH - 1 ) / ( CELL_WIDTH + CELL_H_GAP );
        itemCountVertical += (pageContainer.getHeight() - CELL_HEIGHT - 1 ) / ( CELL_HEIGHT + CELL_V_GAP );
        itemCount = itemCountHorizontal * itemCountVertical;
        itemCount = ( itemCount == 0 ) ? 1 : itemCount;

        pageCount = ITEM_COUNT / itemCount + 1;

        page.setMinWidth( (CELL_WIDTH * itemCountHorizontal) + (CELL_H_GAP * (itemCountHorizontal-1)) );
        page.setMaxWidth( (CELL_WIDTH * itemCountHorizontal) + (CELL_H_GAP * (itemCountHorizontal-1)) );
        page.setMinHeight( (CELL_HEIGHT * itemCountVertical) + (CELL_V_GAP * (itemCountVertical-1)) );
        page.setMaxHeight( (CELL_HEIGHT * itemCountVertical) + (CELL_V_GAP * (itemCountVertical-1)) );

        if ( pagination.getPageCount() != pageCount ) {
            Platform.runLater( () -> {
                pagination.setPageCount(pageCount);
            });
        } else if ( this.itemCount != itemCount ){
            // If item count changed, rebuild the page
            this.itemCount = itemCount;
            page.getChildren().clear();
            fillPage(page, pagination.getCurrentPageIndex());
        }
    }

    private void fillPage ( TilePane page, int pageIndex ) {
        int startIndex = pageIndex * itemCount;
        int endIndex = Math.min( ITEM_COUNT, startIndex+itemCount );
        for ( int i = startIndex; i < endIndex; i++ ) {
            page.getChildren().add(cellFactory("C" + (i+1)));
        }
    }

    private Pane cellFactory( String cellText ) {
        StackPane cell = new StackPane();

        cell.setMaxHeight(CELL_HEIGHT);
        cell.setMinHeight(CELL_HEIGHT);
        cell.setMaxWidth(CELL_WIDTH);
        cell.setMinWidth(CELL_WIDTH);
        cell.setAlignment(Pos.CENTER);
        cell.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        cell.getChildren().add(new Label(cellText));

        return cell;
    }

}