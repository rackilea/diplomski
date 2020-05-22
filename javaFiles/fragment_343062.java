import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListProblem extends Application {

    ObservableList<String> girlNames;
    ObservableList<String> boyNames;

    Button moveLeftButton;
    Button moveRightButton;

    Scene scene1;

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("List Problem");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        GridPane gridPane = new GridPane();
        scene1 = new Scene(gridPane, 350, 200);

        ListView<String> data = new ListView<String>();
        data.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        girlNames = FXCollections.observableArrayList("Meagan Good",
                "Jessica Alba", "Erykah Badu", "Beyonce", "Janet");

        data.setItems(girlNames);

        ListView<String> data2 = new ListView<String>();
        boyNames = FXCollections.observableArrayList("Eddie Murphy",
                "Richord Pryor", "Eddie Griffin", "Kevin Heart", "Mike");

        data2.setItems(boyNames);
        GridPane.setConstraints(data, 0, 0);
        GridPane.setConstraints(data2, 1, 0);

        moveLeftButton = new Button("Move Left");
        moveLeftButton.setPrefSize(200, 30);
        moveLeftButton.setAlignment(Pos.CENTER);

        moveLeftButton.setOnAction(event -> {
            boyNames.addAll(data.getSelectionModel().getSelectedItems());
            girlNames.removeAll(data.getSelectionModel().getSelectedItems());
        });

        GridPane.setConstraints(moveLeftButton, 0, 1);
        moveRightButton = new Button("Move Right");
        moveRightButton.setPrefSize(200, 30);
        moveRightButton.setAlignment(Pos.CENTER);

        moveRightButton.setOnAction(event -> {
            girlNames.addAll(data2.getSelectionModel().getSelectedItem());
            boyNames.remove(data2.getSelectionModel().getSelectedItem());
        });

        GridPane.setConstraints(moveRightButton, 1, 1);
        gridPane.getChildren().addAll(data, data2, moveLeftButton,
                moveRightButton);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}