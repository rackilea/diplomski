import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author reegan
 */
public class Checkboxdemo extends Application {

    static int i = 0;

    @Override
    public void start(Stage primaryStage) {
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue ov,
                    Boolean old_val, Boolean new_val) {
                if (ov.getValue() == true) {
                    i = i + 1;
                    System.out.println(i);

                }

            }
        });

        TableView tableView = new TableView();
        TableColumn column = new TableColumn("check");
        TableColumn column1 = new TableColumn("Name");

        tableView.getColumns().addAll(column,column1);

        VBox root = new VBox();
        root.getChildren().addAll(checkBox,tableView);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);




        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
   // public static void main(String[] args) {
     //   launch(args);
   // }
}