import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

/** @see https://stackoverflow.com/a/44102580/230513 */
public class Home extends Application {

    private TabPane tabpane = new TabPane();
    private Example example = new Example();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        tabpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        Tab tab = new Tab();
        tab.setText("Tab One");
        tab.setContent(example.getContent());
        tabpane.getTabs().add(tab);
        Scene scene = new Scene(tabpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class Example {

        ListView<String> view = new ListView<>();

        public Example() {
            ObservableList<String> list = FXCollections.observableArrayList(
                "Test 1", "Test 2", "Test 3");
            view.setItems(list);
        }

        public ListView getContent() {
            return view;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}