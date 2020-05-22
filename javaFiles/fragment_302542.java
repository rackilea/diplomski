import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.application.Platform;
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
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(5, r -> {
           Thread t = new Thread(r);
           t.setDaemon(true);
           return t ;
        });
        AtomicInteger count = new AtomicInteger();
        Runnable task = () -> {
            System.out.println("Hello world!");
            Platform.runLater(() -> label.setText("Count: "+count.incrementAndGet()));
            System.out.println("Hello again");
        };
        exec.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);
        Scene scene = new Scene(root, 250, 75);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}