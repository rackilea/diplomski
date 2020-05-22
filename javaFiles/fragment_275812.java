import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvokeAllTasks extends Application {

    private Random rng = new Random();
    private ExecutorService exec = Executors.newFixedThreadPool(5);
    private Function<Task<Integer>, Callable<Integer>> taskWrapper = task -> () -> {
        task.run();
        return task.getValue();
    };

    @Override
    public void start(Stage primaryStage) {
        Button runAll = new Button("Run all tasks");
        Label status = new Label();

        runAll.setOnAction(e -> {
            List<Task<Integer>> tasks = createTasks();


            Task<List<Future<Integer>>> runAllTask = new Task<List<Future<Integer>>>() {
                @Override
                protected List<Future<Integer>> call() throws Exception {
                    return exec.invokeAll(tasks.stream().map(taskWrapper).collect(Collectors.toList()));
                }
            };
            status.setText("Running...");
            runAllTask.setOnSucceeded(evt -> status.setText("All Done"));
            new Thread(runAllTask).start();


        });

        VBox root = new VBox(5, runAll, status);
        root.setMinHeight(120);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        exec.shutdown();
    }

    private List<Task<Integer>> createTasks() {
        List<Task<Integer>> tasks = new ArrayList<>();
        for (int i = 1 ; i <= 8 ; i++) {
            String name = "Task "+i;
            Task<Integer> t = new Task<Integer>() {
                @Override
                protected Integer call() throws Exception {
                    System.out.println(name+" running");
                    Thread.sleep(rng.nextInt(1000)+500);
                    int result = rng.nextInt(500);
                    System.out.println(name+" computed "+result);
                    return result;
                }
            };
            tasks.add(t);
        }
        return tasks;
    }

    public static void main(String[] args) {
        launch(args);
    }
}