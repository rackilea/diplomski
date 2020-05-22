import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class GridPaneTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHgrow(Priority.ALWAYS);
        ColumnConstraints middleCol = new ColumnConstraints(40);
        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHgrow(Priority.ALWAYS);


        GridPane gridPane = new GridPane();
        gridPane.getColumnConstraints().addAll(leftCol, middleCol, rightCol);

        Region left = new Region();
        left.setMinHeight(80);
        left.setStyle("-fx-background-color: red;");

        Region middle = new Region();
        middle.setMinHeight(80);
        middle.setStyle("-fx-background-color: green ;");

        Region right = new Region();
        right.setMinHeight(80);
        right.setStyle("-fx-background-color: blue ;");

        gridPane.addRow(0, left, middle, right);

        Scene scene = new Scene(gridPane, 400, 80);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}