import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.*;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Checkout extends Application {

    private static final double SQUARE_SIZE = 20;
    private static final double PIECE_RADIUS = SQUARE_SIZE / 2.5;

    private static final Color WHITE = Color.BEIGE;
    private static final Color BLACK = Color.ROSYBROWN;

    // setupindex, player, position (1-32 index into top to bottom black squares on the board).
    private static final int[][][] setups =
            {
                    {
                            {31, 27, 19},
                            {17, 12, 5}
                    },
                    {
                            {30, 26, 18},
                            {19, 11, 10},
                    },
                    {
                            {31, 24, 19},
                            {18, 11, 10}
                    }
            };
    private static final String SNAPSHOT_FILE_PREFIX = "snapshot-";
    private static final String SNAPSHOT_FILE_SUFFIX = ".png";

    private WritableImage snapshotFxImage =
            new WritableImage((int) (SQUARE_SIZE * 8), (int) (SQUARE_SIZE * 8));
    private BufferedImage snapshotBufferedImage =
            new BufferedImage((int) (SQUARE_SIZE * 8), (int) (SQUARE_SIZE * 8), BufferedImage.TYPE_INT_ARGB);

    private static final String USER_HOME =
            System.getProperties().getProperty("user.home");


    @Override
    public void start(Stage stage) throws IOException {
        Group layout = new Group();
        renderBoard(layout);
        Scene scene = new Scene(layout);

        int i = 0;
        for (int[][] setup : setups) {
            List<Node> pieces = renderSetup(setup);
            layout.getChildren().addAll(pieces);
            snapshot(scene, i);
            layout.getChildren().removeAll(pieces);

            i++;
        }

        Platform.setImplicitExit(false);
        Platform.exit();
    }

    private void renderBoard(Group layout) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Rectangle square = new Rectangle(
                        c * SQUARE_SIZE,
                        r * SQUARE_SIZE,
                        SQUARE_SIZE,
                        SQUARE_SIZE
                );

                Color fill =
                        (((c + r) % 2) == 0)
                                ? Color.WHITE
                                : Color.BLACK;
                square.setFill(fill);

                layout.getChildren().add(square);
            }
        }
    }

    private List<Node> renderSetup(int[][] setup) {
        List<Node> pieces = new ArrayList<>();
        for (int player = 0; player < 2; player++) {
            for (int pieceIndex = 0; pieceIndex < setup[player].length; pieceIndex++) {
                Color fill =
                        player == 0
                                ? WHITE
                                : BLACK;
                Circle piece = new Circle(PIECE_RADIUS, fill);

                pieces.add(piece);
                movePieceTo(piece, setup[player][pieceIndex]);
            }
        }

        return pieces;
    }

    private void movePieceTo(Circle circle, int p) {
        int r = (p - 1) / 4;
        int c = ((p - 1) % 4) * 2 + (((r % 2) == 0) ? 1 : 0);

        circle.setCenterX(c * SQUARE_SIZE + SQUARE_SIZE / 2);
        circle.setCenterY(r * SQUARE_SIZE + SQUARE_SIZE / 2);
    }

    private void snapshot(Scene scene, int snapshotIdx) throws IOException {
        Path path = Paths.get(
                USER_HOME,
                SNAPSHOT_FILE_PREFIX + snapshotIdx + SNAPSHOT_FILE_SUFFIX
        );
        scene.snapshot(snapshotFxImage);
        SwingFXUtils.fromFXImage(snapshotFxImage, snapshotBufferedImage);
        ImageIO.write(snapshotBufferedImage, "png", path.toFile());

        System.out.println("Saved: " + path.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}