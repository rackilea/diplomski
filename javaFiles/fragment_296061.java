import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class IntegerFieldExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField integerField = new TextField();
        UnaryOperator<Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) { 
                return change;
            } else if ("-".equals(change.getText()) ) {
                if (change.getControlText().startsWith("-")) {
                    change.setText("");
                    change.setRange(0, 1);
                    change.setCaretPosition(change.getCaretPosition()-2);
                    change.setAnchor(change.getAnchor()-2);
                    return change ;
                } else {
                    change.setRange(0, 0);
                    return change ;
                }
            }
            return null;
        };

        // modified version of standard converter that evaluates an empty string 
        // as zero instead of null:
        StringConverter<Integer> converter = new IntegerStringConverter() {
            @Override
            public Integer fromString(String s) {
                if (s.isEmpty()) return 0 ;
                return super.fromString(s);
            }
        };

        TextFormatter<Integer> textFormatter = 
                new TextFormatter<Integer>(converter, 0, integerFilter);
        integerField.setTextFormatter(textFormatter);

        // demo listener:
        textFormatter.valueProperty().addListener((obs, oldValue, newValue) -> System.out.println(newValue));

        VBox root = new VBox(5, integerField, new Button("Click Me"));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}