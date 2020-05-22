import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdateLabelRegularly extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        VBox root = new VBox();
        root.getChildren().add(label);
        AtomicInteger count = new AtomicInteger();
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(5, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t ;
        });
        exec.scheduleAtFixedRate(() -> {
            Task<String> task = new Task<String>() {
                @Override
                public String call() {
                    return "Count: "+count.incrementAndGet();
                }
            };
            task.setOnSucceeded(event -> label.setText(task.getValue()));
            task.run();
        }, 1, 1, TimeUnit.SECONDS); 

        Scene scene = new Scene(root, 250, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}