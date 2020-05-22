import java.time.DayOfWeek;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;
public class DatePickerDemo extends Application {
     // Factory to create Cell of DatePicker
    private Callback<DatePicker, DateCell> disableMonday() { 
        final Callback<DatePicker, DateCell> dayCellFactory = (final DatePicker datePicker) -> new DateCell() { 
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);                
                // Disable Monday
                if (item.getDayOfWeek() == DayOfWeek.MONDAY) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }
        };
        return dayCellFactory;
    }

    private Callback<DatePicker, DateCell> disableNotFirstOfMonth() { 
        final Callback<DatePicker, DateCell> dayCellFactory = (final DatePicker datePicker) -> new DateCell() { 
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);                
                // Disable all except first of month
                if (item.getDayOfMonth() != 1) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }
        };
        return dayCellFactory;
    }

    @Override
    public void start(Stage stage) {

        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setShowWeekNumbers(true);

        DatePicker datePicker2 = new DatePicker();
        datePicker2.setValue(LocalDate.now());
        datePicker2.setShowWeekNumbers(true);

        Callback<DatePicker, DateCell> dayCellFactory  = this.disableMonday();
        Callback<DatePicker, DateCell> dayCellFactory2 = this.disableNotFirstOfMonth();
        datePicker.setDayCellFactory(dayCellFactory);
        datePicker2.setDayCellFactory(dayCellFactory2); 

        FlowPane root = new FlowPane();
        root.getChildren().add(datePicker);
        root.getChildren().add(datePicker2);
        root.setPadding(new Insets(20));

        stage.setTitle("DatePicker Demo");
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    } 
}