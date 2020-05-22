noButton.setOnAction(event -> {


    Done=false; //boolean to close and open the frame

    classStage.hide();
    PauseTransition oneHourPause = new PauseTransition(Duration.hours(1));
    oneHourPause.setOnFinished(e -> showUI(classStage));
    oneHourPause.play();
}); 

// ...

private void showUI(Stage stage) {

    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    stage.setX(primaryScreenBounds.getMaxX() - primaryScreenBounds.getWidth());
    stage.setY(primaryScreenBounds.getMaxY() - primaryScreenBounds.getHeight());
    stage.setAlwaysOnTop(true);
    Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
    stage.setTitle("Alerta suspencion de equipo");
    stage.setScene(new Scene(root));
    stage.setResizable(false);
    stage.initStyle(StageStyle.UNDECORATED);
    stage.show();
}