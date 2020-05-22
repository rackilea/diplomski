import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ColoredTabDemo extends Application {

    private int tabCount ;

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        for (int i = 0; i < 4; i++) {
            tabPane.getTabs().add(createTab());
        }
        Scene scene = new Scene(tabPane, 600, 400);
        scene.getStylesheets().add("colored-tab-demo.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createTab() {
        Tab tab = new Tab("Tab "+(++tabCount));
        Button button = new Button("Load file...");

        button.setOnAction(e -> {
            Task<Void> task = new Task<Void>() {
                @Override
                public Void call() throws Exception {

                    // simulate loading:
                    for (int i=1; i <= 500; i++) {
                        updateProgress(i, 500);
                        Thread.sleep(20);
                    }

                    return null ;

                }
            };

            IntegerBinding progressAsPercent = Bindings.createIntegerBinding(() -> 
                (int) (task.getProgress() * 100), task.progressProperty());

            tab.styleProperty().bind(Bindings.format("-fx-background-color: "
                    + "linear-gradient(to right, -fx-accent 0%%, -fx-accent %d%%, -fx-background %1$d%%, -fx-background 100%%);", 
                    progressAsPercent));

            button.setDisable(true);

            task.setOnSucceeded(evt -> {
                tab.styleProperty().unbind();
                tab.setStyle("");
                button.setDisable(false);
            });

            new Thread(task).start();
        });

        tab.setContent(new StackPane(button));

        return tab ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}