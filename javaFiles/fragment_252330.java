import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication155 extends Application
{

    private static final String DATE_TYPE = "DATE";

    private class ComboBoxNode {
        private final Object value;
        private final String type;

        private ComboBoxNode(final Object value, final String type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            return Objects.toString(value);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final ObservableList<ComboBoxNode> items =
                FXCollections.observableArrayList(
                        new ComboBoxNode(LocalDate.now(), DATE_TYPE),
                        new ComboBoxNode(LocalDate.of(2017, Month.APRIL, 15), DATE_TYPE),//Added new date to ComboBox
                        new ComboBoxNode("11:35AM", "TIME"));

        final PopOver datePopOver = new PopOver();
        datePopOver.setTitle("Enter new date");
        datePopOver.setCornerRadius(10);
        datePopOver.setHeaderAlwaysVisible(true);
        //datePopOver.set(true);
        datePopOver.setAutoHide(true);

        final ComboBox<ComboBoxNode> customComboBox = new ComboBox<>(items);


        customComboBox.getSelectionModel().selectedItemProperty().addListener((o, old, newNode) -> {
            if (newNode != null) {
                if (newNode.type.equals(DATE_TYPE)) {
                    final DatePicker datePicker = new DatePicker((LocalDate) newNode.value);
                    datePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
                        items.set(customComboBox.getSelectionModel().getSelectedIndex(), new ComboBoxNode(newDate, DATE_TYPE));//Fixed this line of code
                        datePopOver.hide();
                    });

                    final StackPane stackPane = new StackPane(datePicker);
                    stackPane.setPadding(new Insets(10, 10, 10, 10));

                    datePopOver.setContentNode(stackPane);
                    datePopOver.show(customComboBox);
                } else {
                    datePopOver.hide();
                }
            }
        });

        final FlowPane pane = new FlowPane(customComboBox);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);

        // Show Scene
        final Scene scene = new Scene(pane);
        primaryStage.setTitle("Popup calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}