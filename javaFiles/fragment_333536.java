import javafx.application.*;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Waiter extends Application {

    private static final int N_TASKS = 3;
    private static final int TOTAL_TASK_EXECUTION_TIME_LIMIT_SECS = 20;

    private final VBox layout = new VBox(10);

    @Override
    public void start(Stage stage) throws Exception {
        Button run = new Button("Run");
        run.setOnAction(this::work);

        layout.getChildren().add(run);
        layout.setPadding(new Insets(10));
        layout.setPrefSize(100, 150);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private void work(Event event) {
        Node controlNode = (Node) event.getSource();

        ExecutorService exec = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "load");
            t.setDaemon(true);
            return t;
        });

        ExecutorService monitor = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "monitor");
            t.setDaemon(true);
            return t;
        });

        final List<LoadingTask> tasks = new ArrayList<>();
        for (int j = 0; j < N_TASKS; j++) {
            LoadingTask loadingTask = new LoadingTask();
            ProgressBar progressBar = new ProgressBar();
            progressBar.progressProperty().bind(loadingTask.progressProperty());
            layout.getChildren().add(progressBar);

            tasks.add(loadingTask);
        }

        Task<Void> taskRunner = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                tasks.forEach(exec::submit);
                exec.shutdown();
                boolean cleanShutdown = exec.awaitTermination(
                        TOTAL_TASK_EXECUTION_TIME_LIMIT_SECS,
                        TimeUnit.SECONDS
                );
                if (!cleanShutdown) {
                    exec.shutdownNow();
                }

                Platform.runLater(() ->
                        layout.getChildren()
                                .removeIf(
                                        node -> node instanceof ProgressBar
                                )
                );

                return null;
            }
        };
        controlNode.disableProperty().bind(taskRunner.runningProperty());
        monitor.submit(taskRunner);
        monitor.shutdown();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class LoadingTask extends Task<Void> {
        @Override
        public Void call() {
            for (int i = 1; i <= 100; i++) {
                if (isCancelled() || Thread.interrupted()) {
                    break;
                }
                updateProgress(i, 100);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return null;
        }
    }
}