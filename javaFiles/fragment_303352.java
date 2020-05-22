MenuItem fullScreen = new MenuItem();

fullScreen.textProperty().bind(
     new When(primaryStage.fullScreenProperty())
          .then("Exit Full Screen")
          .otherwise("Full Screen"));

fullScreen.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        primaryStage.setFullScreen(!primaryStage.isFullScreen());
    }
});