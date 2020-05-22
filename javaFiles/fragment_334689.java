double secondsPerCompleteCycle = (360.0 / 0.75) * 0.04 ;
Rotate rotation = new Rotate(0, new Point3D(1, 0, 0));
group.getTransforms().add(rotation);
Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(secondsPerCompleteCycle), 
    new KeyValue(rotation.angleProperty(), 360, Interpolator.LINEAR)));
timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();