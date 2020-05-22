import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class NumericTextField extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c ;
            } else {
                return null ;
            }
        };

        StringConverter<Double> converter = new StringConverter<Double>() {

            @Override
            public Double fromString(String s) {
                if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                    return 0.0 ;
                } else {
                    return Double.valueOf(s);
                }
            }


            @Override
            public String toString(Double d) {
                return d.toString();
            }
        };

        TextFormatter<Double> textFormatter = new TextFormatter<>(converter, 0.0, filter);
        TextField textField = new TextField();
        textField.setTextFormatter(textFormatter);

        textFormatter.valueProperty().addListener((ObservableValue<? extends Double> obs, Double oldValue, Double newValue) -> {
            System.out.println("User entered value: "+newValue.doubleValue());
        });

        VBox root = new VBox(5, textField, new TextField());
        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}