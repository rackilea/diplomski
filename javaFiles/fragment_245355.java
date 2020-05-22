Animation delay = new PauseTransition(Duration.seconds(2));
delay.setOnFinished(e -> {
    mediaPlayer.play();
    benCafBox.setLayoutX(0);
    benCafBox.setLayoutY(0);
    benCafBox.setWidth(320);
    benCafBox.setHeight(35);
});

benCafCol.addEventHandler(MouseEvent.MOUSE_ENTERED, 
    e -> delay.playFromStart());

benCafCol.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
    delay.stop();

    mediaPlayer.stop();

    //default terms

    benCafBox.setLayoutX(5);
    benCafBox.setLayoutY(5);
    benCafBox.setWidth(310);
    benCafBox.setHeight(25);
});