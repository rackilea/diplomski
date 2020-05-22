import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxSample extends Application {

    @Override
    public void start(Stage stage) {

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setEditable(true);
        comboBox.getItems().addAll("A", "B", "C", "D", "E");
        comboBox.setValue("A");


        // restrict input
        TextField textField = comboBox.getEditor();
        TextFormatter<String> formatter = new TextFormatter<String>(change -> {
            change.setText(change.getText().replaceAll("[^a-z ()]", ""));
            return change;

        });
        textField.setTextFormatter(formatter);

        // dummy textfield to jump to on ENTER press
        TextField dummyTextField = new TextField();

        comboBox.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if( e.getCode() == KeyCode.ENTER) {
                dummyTextField.requestFocus();
                e.consume();
            }
        });

        HBox root = new HBox();

        root.getChildren().addAll(comboBox, dummyTextField);

        Scene scene = new Scene(root, 450, 250);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}