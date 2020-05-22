scene.setOnMouseClicked(event -> {
    double rawMouseX = event.getX();
    double rawMouseY = event.getY();

    double normalizedMouseX = rawMouseX - duck.getTranslateX();
    double normalizedMouseY = rawMouseY - duck.getTranslateY();

    if (duck.contains(normalizedMouseX, normalizedMouseY)){
        //increment score
        incrementScore();
        scoreDisplay.setText(""+score+"00");
    }
});