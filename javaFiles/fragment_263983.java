import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IntermediateTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        TableView<Integer> tv = new TableView<>();
        TableColumn<Integer, Integer> num = new TableColumn<>("Number");
        num.setCellValueFactory(v -> new ReadOnlyObjectWrapper(v.getValue()));
        tv.getColumns().add(num);
        PartialResultsTask prt = new PartialResultsTask();
        tv.setItems(prt.getPartialResults());

        ListView<Integer> lv = new ListView<>();
        PartialResultsTask prt1 = new PartialResultsTask();
        lv.setItems(prt1.getPartialResults());
        new Thread(prt).start();
        new Thread(prt1).start();

        // Create a window & add the table
        VBox root = new VBox();
        root.getChildren().addAll(tv, lv);
        Scene scene = new Scene(root, 300, 450);

        primaryStage.setTitle("Data-Adding");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public class PartialResultsTask extends Task<ObservableList<Integer>> {

        private ReadOnlyObjectWrapper<ObservableList<Integer>> partialResults
                = new ReadOnlyObjectWrapper<>(this, "partialResults",
                        FXCollections.observableArrayList(new ArrayList()));

        public final ObservableList getPartialResults() {
            return partialResults.get();
        }

        public final ReadOnlyObjectProperty<ObservableList<Integer>> partialResultsProperty() {
            return partialResults.getReadOnlyProperty();
        }

        @Override
        protected ObservableList call() throws Exception {
            updateMessage("Creating Integers...");
            Random rnd = new Random();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                if (isCancelled()) {
                    break;
                }
                final Integer r = rnd.ints(100, 10000).findFirst().getAsInt();
                Platform.runLater(() -> {
                    getPartialResults().add(r);
                });
                updateProgress(i, 10);
            }
            return partialResults.get();
        }
    }

}