import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InputReversal extends Application {    
    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Label label = new Label();
        label.textProperty().bind(
                Bindings.createStringBinding(
                        () -> new StringBuilder(textField.getText()).reverse().toString(),
                        textField.textProperty()
                )
        );

        VBox layout = new VBox(10, textField, label);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}