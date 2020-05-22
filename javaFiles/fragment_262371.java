void cleanup() {
    // stop animations reset model ect.
}

void startGame(Stage stage) {
    // initialisation from start method goes here

    btnNewGame.setOnAction(e -> {
       restart(stage);
    });

    stage.show();
}

void restart(Stage stage) {
    cleanup();
    startGame(stage);
}

@Override
public void start(Stage primaryStage) {
    startGame(primaryStage);
}