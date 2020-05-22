import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root = new AnchorPane();

        DatePicker datePicker = new DatePicker();
        datePicker.setMinHeight(12.);
        datePicker.setPrefHeight(16.);
        datePicker.setMaxHeight(60.);
        HBox hBox = new HBox();
        hBox.getChildren().add(new Label("DatePicker with 60px height"));
        hBox.getChildren().add(datePicker);

        HBox hBox1 = new HBox();
        DatePicker datePicker1 = new DatePicker();
        hBox1.getChildren().add(new Label("DatePicker with default height"));
        hBox1.getChildren().add(datePicker1);
        VBox vBox = new VBox(25);
        vBox.getChildren().addAll(hBox, hBox1);
        root.getChildren().add(vBox);
        Scene scene = new Scene(root);

        stage.setTitle("JavaFXs' DatePicker and the setPrefHeigth() method");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}