import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Sample extends Application {

    public void start(Stage stage) throws Exception {
        String blackBorder = "-fx-border-style: solid; -fx-border-width: 1; -fx-border-color: black";

        Button calculate = new Button("Calculate");
        Button cancel = new Button("Cancel");
        HBox runButtons = new HBox(calculate, cancel);
        calculate.prefWidthProperty().bind(runButtons.widthProperty().divide(2));
        cancel.prefWidthProperty().bind(runButtons.widthProperty().divide(2));
        VBox rightCol = new VBox(runButtons);
        rightCol.setStyle(blackBorder);

        Button save = new Button("Save");
        Button del = new Button("Delete");
        HBox settings = new HBox(save, del);
        save.prefWidthProperty().bind(settings.widthProperty().divide(3)); // 1/3
        del.prefWidthProperty().bind(settings.widthProperty().divide(3).multiply(2)); // 2/3
        VBox leftCol = new VBox(settings);
        leftCol.setStyle(blackBorder);


        GridPane root = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        root.getColumnConstraints().addAll(col1,col2);
        root.addRow(0, leftCol,rightCol);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... a) {
        Application.launch(a);
    }
}