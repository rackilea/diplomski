splashStage.show();
PauseTransition pause = new PauseTransition(Duration.seconds(3_000));
pause.setOnFinished(event -> {
        Stage mainStage = new Stage();
        mainStage.setScene(createMainScene());
        mainStage.show();
        splashStage.hide();
});
pause.play();