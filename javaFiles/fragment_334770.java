import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GameBoard gameBoard = new GameBoard();

        BorderPane mainPane = new BorderPane();

        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> {
            gameBoard.restartGame();
        });

        FlowPane controlPane = new FlowPane();
        controlPane.setAlignment(Pos.CENTER);
        controlPane.getChildren().add(restartButton);

        mainPane.setCenter(gameBoard);
        mainPane.setBottom(controlPane);

        stage.setScene(new Scene(mainPane, 600, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}