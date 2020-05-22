import java.util.Map;
import java.util.HashMap;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;

public class ScreenController {

    private final Map<String, Foo> map = new HashMap<>();
    private final Scene scene;

    public ScreenController(Scene scene) {
        this.scene = scene;
    }

    public void register(String name, Pane pane) {
        map.put(name, pane);
    }

    public void activate(String name) {
        scene.setRoot(map.get(name).pane);
    }

    private static class Foo {

        private final Pane pane;
        private final Dimension2D normalSize;
        private final Dimension2D fullScreenSize;
        private final Scale scale;

        private Foo(Pane pane) {
            this.pane = pane;
            // set the other fields...
        }

        private void enterFullScreenMode() {
             pane.setPrefSize(fullScreenSize.getWidth(), fullScreenSize.getHeight());
             pane.getTransforms().add(scale);
        }

        private void exitFullScreenMode() {
             pane.setPrefSize(normalSize.getWidth(), normalSize.getHeight());
             pane.getTransforms().remove(scale);
        }

    }

}