private final Group shapes = new Group();
private long lastTimerCall;
private AnimationTimer timeline;

@Override
public void start(Stage stage) throws Exception {
    Scene scene = new Scene(createRotatingShapes(), 400, 300,
            true, SceneAntialiasing.BALANCED);
    scene.setFill(Color.LIGHTGREEN);
    final PerspectiveCamera camera = new PerspectiveCamera();
    camera.setRotationAxis(Rotate.X_AXIS);
    camera.setRotate(10);
    camera.setTranslateZ(200);
    scene.setCamera(camera);

    stage.setScene(scene);
    stage.show();
}

private Group createRotatingShapes() {
    final Box box1 = new Box(50, 50, 50);
    // Transparency in box1: last node of the group
    box1.setMaterial(new PhongMaterial(Color.web("#0000FF80")));

    box1.setTranslateZ(50);

    final Box box2 = new Box(10, 10, 10);
    box2.setMaterial(new PhongMaterial(Color.RED));

    box2.setTranslateZ(-50);

    shapes.getChildren().addAll(box2, box1);

    shapes.setTranslateX(200);
    shapes.setTranslateY(150);

    rotateAroundYAxis(box2);

    return shapes;
}

private int count = 0;
private void rotateAroundYAxis(Node node) {
    Rotate r = new Rotate(0, 0, 0, 100, Rotate.Y_AXIS);
    node.getTransforms().add(r);
    lastTimerCall = System.nanoTime();
    timeline = new AnimationTimer() {
        @Override public void handle(long now) {
            if (now > lastTimerCall + 100_000_000l) {
                r.setAngle((count++)%360);
            }
        }
    };
    timeline.start();
}


@Override
public void stop() {
    timeline.stop();
}