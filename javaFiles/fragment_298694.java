private void fadeInPane(Pane pane) {
     FadeTransition fadeIn = new FadeTransition(Duration.millis(2900), pane);
     fadeIn.setFromValue(0);
     fadeIn.setToValue(1);
     fadeIn.setOnFinished(e -> fadeOutPane(pane));
     fadeIn.play();
}