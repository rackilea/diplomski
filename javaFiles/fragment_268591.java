@FXML
private void minimizeWindow(MouseEvent event) {
    Stage window = (Stage) ((Rectangle) event.getSource()).getScene().getWindow();
    this.minButton.setStyle("-fx-fill: blue;");

    AnimationTimer timer = new AnimationTimer() {

        int count = 2;

        @Override
        public void handle(long now) {
            if (--count <= 0) {
                window.setIconified(true);
                this.stop();
            }
        }

    };

    timer.start();
}