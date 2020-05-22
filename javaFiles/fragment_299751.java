import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertiesExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple interface
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create our Player
        Player player = new Player("Mario");

        // For this example, a simple GridPane will hold our nodes
        GridPane gridPane = new GridPane();

        // Add our data headers
        gridPane.add(new Label("Player:"), 0, 0);
        gridPane.add(new Label("Score:"), 0, 1);

        // Our labels to hold the changeable data
        Label lblPlayerName = new Label();
        Label lblPlayerScore = new Label();
        gridPane.add(lblPlayerName, 1, 0);
        gridPane.add(lblPlayerScore, 1, 1);

        // Use the Player properties to bind our displayed values to the Labels
        lblPlayerName.textProperty().bind(player.playerNameProperty());
        lblPlayerScore.textProperty().bind(player.scoreProperty().asString());

        Button btnIncrementScore = new Button("Score Up");
        btnIncrementScore.setOnAction(event -> player.incrementScore());

        root.getChildren().addAll(gridPane, btnIncrementScore);

        // Show the Stage
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

class Player {
    private StringProperty playerName = new SimpleStringProperty();
    private IntegerProperty score = new SimpleIntegerProperty();

    public Player(String playerName) {
        this.playerName.set(playerName);
        this.score.set(0);
    }

    public void incrementScore() {
        // Add 1 point to our score IntegerProperty
        this.score.set(score.get() + 1);
        System.out.println(score.get());
    }

    public String getPlayerName() {
        return playerName.get();
    }

    public StringProperty playerNameProperty() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName.set(playerName);
    }

    public int getScore() {
        return score.get();
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }
}