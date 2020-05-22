@Override
public void handle(ActionEvent event) {
    RotateTransition animation = new RotateTransition(Duration.seconds(60), imageHolder2);
    animation.setByAngle(360);
    animation.play();
}