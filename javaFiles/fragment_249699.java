import java.text.DateFormat;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = new VBox();
            Scene scene = new Scene(root,400,400);

            DatePickerControl datePicker = new DatePickerControl();
            Label label = new Label();
            final DateFormat calFormatter = DateFormat.getDateInstance() ;
            datePicker.calendarProperty().addListener((obs, oldValue, newValue) -> label.setText(calFormatter.format(newValue.getTime())));
            root.getChildren().addAll(datePicker, label);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}