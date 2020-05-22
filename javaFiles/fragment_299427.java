@FXML
protected void solveClicked(ActionEvent event) {
    Timeline timeline = new Timeline(
        new KeyFrame(Duration.millis(500), e -> L()),
        new KeyFrame(Duration.millis(1000), e -> R()),
        new KeyFrame(Duration.millis(1500), e -> F()),
        new KeyFrame(Duration.millis(2000), e -> B()));
    timeline.play();
}