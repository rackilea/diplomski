private static void animateSphere(Sphere sphere) {
     CylinderCoordinateAdapter adapter = new CylinderCoordinateAdapter(
            sphere.translateXProperty(),
            sphere.translateYProperty(),
            sphere.translateZProperty());

    adapter.setRadius(50);

    Timeline tl = new Timeline(
            new KeyFrame(Duration.ZERO,
                         new KeyValue(adapter.hProperty(), 0d),
                         new KeyValue(adapter.thetaProperty(), 0d)),
            new KeyFrame(Duration.seconds(4),
                         new KeyValue(adapter.hProperty(), 900d, Interpolator.LINEAR),
                         new KeyValue(adapter.thetaProperty(), Math.PI * 4, Interpolator.LINEAR))
    );
    tl.setCycleCount(Timeline.INDEFINITE);
    tl.play();
}