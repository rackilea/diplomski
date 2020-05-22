noButton.setOnAction(event -> {


    Done=false; //boolean to close and open the frame

    classStage.hide();
    PauseTransition oneHourPause = new PauseTransition(Duration.hours(1));
    oneHourPause.setOnFinished(e -> classStage.show());
    oneHourPause.play();
});