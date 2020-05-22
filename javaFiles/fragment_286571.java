@Override
public void handle(ActionEvent event) {
    Timeline timeline = new Timeline(
        // key frame that updates rotation on each second:
        new KeyFrame(Duration.seconds(1), e -> {
            imageHolder2.setRotate(imageHolder2.getRotate() + 6);
            System.out.println("Seconds in current minute = " + Calendar.getInstance().get(Calendar.SECOND));
        })
    );
    // repeat 60 times:
    timeline.setCycleCount(60);
    timeline.play();
}