import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;
import java.util.prefs.BackingStoreException;

public class HighScoreApp extends Application {

    private static ScoreStorage scoreStorage;

    private Random random = new Random(42);

    @Override
    public void start(Stage stage) throws Exception {
        ListView<Integer> scoreList = new ListView<>(scoreStorage.getUnmodifiableScores());
        scoreList.setPrefHeight(150);

        Label lastScoreLabel = new Label();

        Button generateScore = new Button("Generate new score");
        generateScore.setOnAction(event -> {
            int lastScore = random.nextInt(11_000);
            lastScoreLabel.setText("" + lastScore);
            scoreStorage.recordScore(lastScore);
        });

        Button clearScores = new Button("Clear scores");
        clearScores.setOnAction(event -> scoreStorage.clearScores());

        HBox scoreGenerator = new HBox(10, generateScore, lastScoreLabel);
        scoreGenerator.setAlignment(Pos.BASELINE_LEFT);

        VBox layout = new VBox(10, scoreGenerator, scoreList, clearScores);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    public static void main(String[] args) throws BackingStoreException {
        scoreStorage = new ScoreStorage();
        launch(args);
    }
}