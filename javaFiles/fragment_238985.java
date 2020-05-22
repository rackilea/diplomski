import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResizingTextArea extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        textArea.sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> obs, Scene oldScene, Scene newScene) {
                if (newScene != null) {
                    textArea.applyCSS();
                    Node text = textArea.lookup(".text");
                    textArea.prefHeightProperty().bind(Bindings.createDoubleBinding(new Callable<Double>() {
                        @Override
                        public Double call() {
                            return 2+text.getBoundsInLocal().getHeight();
                        }
                    }), text.boundsInLocalProperty()));
                }
            }
        });

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}