import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button attack, run, drinkPotion, nextRoom;
    BorderPane root;
    HBox buttonContainer, roomContainer;
    Scene scene;

    public void createNode() {
        root = new BorderPane();
        scene = new Scene(root, 860, 640);

        attack = new Button("Attack");
        run = new Button("Run!");
        drinkPotion = new Button("Drink Potion!");
        nextRoom = new Button("Go to next room...");

        buttonContainer = new HBox(12);
        buttonContainer.getChildren().addAll(attack, run, drinkPotion);
        buttonContainer.setAlignment(Pos.BOTTOM_CENTER);


        roomContainer = new HBox();
        roomContainer.getChildren().addAll(nextRoom);
        roomContainer.setAlignment(Pos.BOTTOM_CENTER);


        root.setLeft(buttonContainer);
        root.setRight(roomContainer);
    }

    @Override
    public void start(Stage stage) {
        createNode();
        stage.setScene(scene);
        stage.show();
    }
}