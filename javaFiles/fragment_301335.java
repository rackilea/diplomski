import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button attack, run, drinkPotion, nextRoom;
    AnchorPane root;
    HBox buttonContainer, roomContainer;
    Scene scene;

    public void createNode() {
        root = new AnchorPane();
        scene = new Scene(root, 860, 640);

        attack = new Button("Attack");
        run = new Button("Run!");
        drinkPotion = new Button("Drink Potion!");
        nextRoom = new Button("Go to next room...");

        buttonContainer = new HBox(12);
        buttonContainer.getChildren().addAll(attack, run, drinkPotion);

        roomContainer = new HBox();
        roomContainer.getChildren().addAll(nextRoom);

        AnchorPane.setBottomAnchor(buttonContainer, 0.0);
        AnchorPane.setLeftAnchor(buttonContainer, 0.0);

        AnchorPane.setBottomAnchor(roomContainer, 0.0);
        AnchorPane.setRightAnchor(roomContainer, 0.0);

        root.getChildren().addAll(roomContainer, buttonContainer);
    }

    @Override
    public void start(Stage stage) {
        createNode();
        stage.setScene(scene);
        stage.show();
    }
}