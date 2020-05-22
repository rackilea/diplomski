Affine transform = new Affine() ; // creates identity transform
node.getTransforms().add(transform);

Timeline timeline = new Timeline(Duration.seconds(0.04), event -> {
    double shiftX = ... ;
    double shiftY = ... ;
    double scaleX = ... ;
    double scaleY = ... ;
    double angle = 0.75 ;
    Affine change = new Affine();
    change.append(new Translate(shiftX, shiftY));
    change.append(new Scale(scaleX, scaleY));
    change.append(new Rotate(angle, new Point3D(1, 0, 0)));
    transform.append(change);
});

timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();