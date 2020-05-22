import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UpdateLabelRegularly extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        VBox root = new VBox();
        root.getChildren().add(label);
        AtomicInteger count = new AtomicInteger();
        ScheduledService<String> service = new ScheduledService<String>() {
            @Override
            protected Task<String> createTask() {
                Task<String> task = new Task<String>() {
                    @Override
                    public String call() {
                        return "Count: "+count.incrementAndGet();
                    }
                };
                return task ;
            }
        };
        service.setOnSucceeded(event -> label.setText(service.getValue()));
        service.setDelay(Duration.seconds(1));
        service.setPeriod(Duration.seconds(1));
        service.start();
        Scene scene = new Scene(root, 250, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}