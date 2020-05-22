import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableTest extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        TableView<String> tv = new TableView(FXCollections.observableArrayList(
                new ArrayList<String>(Arrays.asList(new String[]{
                    "a","bb","ccc","dddd","eeeee"
                }))));
        TableColumn<String, String> tc = new TableColumn<>("string");
        tc.setCellValueFactory((p) -> {
            return new ReadOnlyStringWrapper(p.getValue());
        });
        tv.getColumns().add(tc);
        stage.setScene(new Scene(tv));
        stage.show();
    }

}