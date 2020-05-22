PauseTransition pause = new PauseTransition(Duration.seconds(1));
textField.textProperty().addListener(
    (observable, oldValue, newValue) -> {
        pause.setOnFinished(event -> doSomething(newValue));
        pause.playFromStart();
    }
);