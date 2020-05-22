@FXML
private void handleButtonAction() {
    System.out.println("You clicked me!");

    Rotate rotate = new Rotate(0, pivotX, pivotY);

    lancettaQuadroCentrale.getTransforms().add(rotate);

    Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0d)),
                                     new KeyFrame(Duration.seconds(4), new KeyValue(rotate.angleProperty(), 220d)));      

    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.setAutoReverse(true);

    timeline.play();
}