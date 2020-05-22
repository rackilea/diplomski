import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends Application {

    private List<Integer> integerList;

    @Override
    public void init() {
        /*
         * If there is at least one parameter attempt to parse the
         * first one as an Integer. This value will be used as the
         * size of the randomly generated "integerList".
         *
         * If there are no parameters then default to 10 million.
         */
        List<String> params = getParameters().getRaw();
        if (!params.isEmpty()) {
            generateRandomList(Integer.parseInt(params.get(0)));
        } else {
            generateRandomList(10_000_000);
        }
    }

    private void generateRandomList(int size) {
        System.out.printf("Generating random list of %,d integers...%n", size);
        Random r = new Random();
        integerList = Stream.generate(() -> r.nextInt(size))
                .limit(size)
                .collect(Collectors.toList());
        System.out.println("List generated.");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Building scene graph...");
        ListView<Integer> listView = new ListView<>();
        listView.setPrefWidth(500);
        listView.getItems().addAll(integerList);

        Button btn = new Button("Sort List");
        btn.setOnAction(ae -> {
            ae.consume();
            btn.setDisable(true);

            /*
             * Here we create the task and configure it to set items of the listView
             * to the result. We do this because we are sorting "integerList" which
             * we had *copied* into the ListView. If  we sorted the items of the ListView
             * then we would be altering the UI from a background thread (big no-no!).
             * Therefore we need to re-copy the "integerList" into the ListView upon
             * completion of the task.
             */
            SortingTask<Integer> task = new SortingTask<>(integerList, null);
            task.setOnSucceeded(wse -> listView.getItems().setAll(task.getValue()));

            Alert alert = createProgressAlert(primaryStage, task);
            executeTask(task);
            alert.show();
        });

        VBox root = new VBox(btn, listView);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        VBox.setVgrow(listView, Priority.ALWAYS);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Progress Alert Example");
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("Primary stage displayed.");
    }

    // executes task on a separate, daemon thread
    private void executeTask(Task<?> task) {
        Thread t = new Thread(task, "sorting-thread");
        t.setDaemon(true);
        t.start();
    }

    // creates the Alert and necessary controls to observe the task
    private Alert createProgressAlert(Stage owner, Task<?> task) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.initOwner(owner);
        alert.titleProperty().bind(task.titleProperty());
        alert.contentTextProperty().bind(task.messageProperty());

        ProgressIndicator pIndicator = new ProgressIndicator();
        pIndicator.progressProperty().bind(task.progressProperty());
        alert.setGraphic(pIndicator);

        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.getDialogPane().lookupButton(ButtonType.OK)
                .disableProperty().bind(task.runningProperty());

        alert.getDialogPane().cursorProperty().bind(
                Bindings.when(task.runningProperty())
                    .then(Cursor.WAIT)
                    .otherwise(Cursor.DEFAULT)
        );

        return alert;
    }

    // The Task implementation

    private static class SortingTask<E> extends Task<List<E>> {

        private final List<E> list;
        private final Comparator<? super E>  comparator;

        private SortingTask(List<E> list, Comparator<? super E> comparator) {
            this.list = Objects.requireNonNull(list);
            this.comparator = comparator; // if null then natural order is used by List.sort
            updateTitle("Sorting Task");
        }

        @Override
        protected List<E> call() throws Exception {
            updateMessage("Sorting list...");
            list.sort(comparator);
            updateMessage("Sorting complete.");
            updateProgress(1, 1);
            return list;
        }

        @Override
        protected void running() {
            System.out.println("Sorting task is running...");
        }

        @Override
        protected void succeeded() {
            System.out.println("Sorting task successful.");
        }

    }

}