import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TrainProgressBar extends Application {

    @Override
    public void start(Stage primaryStage) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0);
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            startButton.setDisable(true);
            Task<Void> task = new Task<Void>() {
                @Override
                public Void call() throws Exception {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(20);
                        updateProgress(i, 100);
                    }
                    updateProgress(100, 100);
                    return null ;
                }
            };
            progressBar.progressProperty().bind(task.progressProperty());
            task.setOnSucceeded(evt -> startButton.setDisable(false));
            new Thread(task){{setDaemon(true);}}.start();
        });

        VBox root = new VBox(15, progressBar, startButton);
        Scene scene = new Scene(root, 250, 100);
        scene.getStylesheets().add("train-progress-bar.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}