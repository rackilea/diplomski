double degreesPerFrame = 0.75 ;
LongProperty frameCount = new SimpleLongProperty();
Rotate rotation = new Rotate(0, new Point3D(1, 0, 0));
group.getTransforms().add(rotation);
rotation.angleProperty().bind(frameCount.multiply(degreesPerFrame));

Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.04), e -> 
    frameCount.set(frameCount.get() + 1)));
timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();

// to reset to the beginning:
timeline.stop();
frameCount.set(0L);