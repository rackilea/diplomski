Timeline timer;

@FXML
void unlockBtn(ActionEvent event) {
    createTimer(5.0);
}

private void createTimer(double seconds) {
   if (timer != null) {
       timer.stop();
   }
   timer = new Timeline(new KeyFrame(Duration.seconds(seconds), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("this is called every"+seconds+"seconds on UI thread");
        }
    }));
    timer.setCycleCount(Timeline.INDEFINITE);
    timer.play();
}

@FXML
void upgradeSecondsBtn(ActionEvent event) {
    createTimer(2.0);
}