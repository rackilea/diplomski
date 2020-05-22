PauseTransition pause = new PauseTransition(Duration.millis(700));
pause.setOnFinished(e -> {
    card.closeCard();

    // ... etc...

    card.getParent().setDisable(false);
});

card.getParent().setDisable(true);
pause.play();