import java.util.function.IntFunction;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

/**
 * @see http://www.w3.org/TR/SVG/paths.html
 * @see http://raphaeljs.com/icons/
 */
public class SVGIcons extends Application {

    private static final int SIZE = 16;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().add(createRow(this::lines));
        root.getChildren().add(createRow(this::curve));
        root.getChildren().add(createRow(this::arc));
        Scene scene = new Scene(root);
        stage.setTitle("SVGIcons");
        stage.setScene(scene);
        stage.show();
    }

    private HBox createRow(IntFunction<SVGPath> path) {
        HBox row = new HBox(10);
        row.setAlignment(Pos.CENTER);
        for (int i = 2; i < 6; i++) {
            row.getChildren().add(path.apply(i * SIZE));
        }
        return row;
    }

    private SVGPath lines(int size) {
        SVGPath path = new SVGPath();
        path.setFill(Color.ALICEBLUE);
        path.setStroke(Color.BLUE);
        path.setContent("M0," + size + "L" + size / 2 + ",0 "
            + size + "," + size + " " + size / 2 + "," + 2 * size / 3 + "z");
        return path;
    }

    private SVGPath curve(int size) {
        SVGPath path = new SVGPath();
        path.setFill(Color.HONEYDEW);
        path.setStroke(Color.GREEN);
        path.setContent("M0,0Q" + size + ",0,"
            + size + "," + size + "L0," + size + "z");
        return path;
    }

    private SVGPath arc(int size) {
        SVGPath path = new SVGPath();
        path.setFill(Color.MISTYROSE);
        path.setStroke(Color.RED);
        path.setContent("M0,0A" + size / 2 + "," + size
            + ",0,1,0," + size + ",0z");
        return path;
    }

    public static void main(String[] args) {
        launch(args);
    }
}