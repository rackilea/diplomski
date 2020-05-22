private void fadeOutPane(Pane pane) {
     FadeTransition fadeOut = new FadeTransition(Duration.millis(1900), pane);
     fadeOut.setFromValue(1);
     fadeOut.setToValue(0);
     fadeOut.play();
}