private static void animateSphere(Sphere sphere) {
    Rotate rot = new Rotate();
    Translate radiusTranslate = new Translate(50, 0, 0);
    Translate zMovement = new Translate();

    sphere.getTransforms().setAll(zMovement, rot, radiusTranslate);
    Timeline tl = new Timeline(
            new KeyFrame(Duration.ZERO,
                         new KeyValue(zMovement.zProperty(), 0d),
                         new KeyValue(rot.angleProperty(), 0d)),
            new KeyFrame(Duration.seconds(4),
                         new KeyValue(zMovement.zProperty(), 900d, Interpolator.LINEAR),
                         new KeyValue(rot.angleProperty(), 720, Interpolator.LINEAR))
    );
    tl.setCycleCount(Timeline.INDEFINITE);
    tl.play();
}

@Override
public void start(Stage primaryStage) {
    Sphere sphere = new Sphere(30);

    Pane root = new Pane(sphere);

    Scene scene = new Scene(root, 400, 400, true);
    PerspectiveCamera camera = new PerspectiveCamera();
    camera.setTranslateZ(-10);
    camera.setTranslateX(-500);
    camera.setTranslateY(-200);
    camera.setRotationAxis(new Point3D(0, 1, 0));
    camera.setRotate(45);
    scene.setCamera(camera);

    animateSphere(sphere);

    primaryStage.setScene(scene);
    primaryStage.show();
}