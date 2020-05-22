import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.stream.Collectors;

public class Layup extends Application {

    private final Random random = new Random(42);

    // image license: linkware - backlink to http://www.fasticon.com
    private static final String[] IMAGE_LOCS = {
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Blue-Fish-icon.png",
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Red-Fish-icon.png",
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Yellow-Fish-icon.png",
            "http://icons.iconarchive.com/icons/fasticon/fish-toys/128/Green-Fish-icon.png"
    };

    @Override
    public void start(Stage stage) throws Exception {
        TilePane tilePane = createTilePane(IMAGE_LOCS);

        Scene scene = new Scene(new Group(tilePane));

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Click on the scene to animate");

        animateIn(tilePane);

        scene.setOnMouseClicked(event -> animateIn(tilePane));
    }

    private TilePane createTilePane(String[] imageLocs) {
        TilePane tilePane = new TilePane(10, 10);
        tilePane.setPrefColumns(2);

        Arrays.stream(imageLocs).map(
                loc -> new ImageView(new Image(
                        loc, 64, 0, true, true
                ))
        ).collect(Collectors.toCollection(tilePane::getChildren));

        tilePane.setPadding(new Insets(200));
        return tilePane;
    }

    private void animateIn(TilePane tilePane) {
        // layout tilePane
        tilePane.applyCss();
        tilePane.layout();

        double W = (int) tilePane.getScene().getWidth();
        double H = (int) tilePane.getScene().getHeight();

        ParallelTransition pt = new ParallelTransition();

        for (int i = 0; i < IMAGE_LOCS.length; i++) {
            Node child = tilePane.getChildren().get(i);

            Point2D start = new Point2D(
                    random.nextInt((int) (W - child.getBoundsInLocal().getWidth())),
                    random.nextInt((int) (H - child.getBoundsInLocal().getHeight()))
            );

            Point2D startInLocal = child.sceneToLocal(start);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(.5), child);
            tt.setFromX(startInLocal.getX());
            tt.setFromY(startInLocal.getY());
            tt.setToX(0);
            tt.setToY(0);

            pt.getChildren().add(tt);
        }

        pt.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}