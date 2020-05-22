private final Rotate rotate = new Rotate(0, 0, 0, 0, javafx.geometry.Point3D.ZERO.add(1, 1, 1));

@Override
public void start(Stage primaryStage) throws Exception {

    final Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(10), 
            new KeyValue(rotate.angleProperty(), 360)));

    final Qubit3D qubit = new Qubit3D();

    final BorderPane root = new BorderPane(qubit);

    final Button buttonAnimate = new Button("Animate");
    buttonAnimate.setOnAction(e -> {
        rotate.setAngle(0);
        timeline.playFromStart();
    });

    root.setLeft(new StackPane(buttonAnimate));
    final Button buttonStop = new Button("Stop");
    buttonStop.setOnAction(e -> timeline.stop());
    root.setRight(new StackPane(buttonStop));

    Scene scene = new Scene(root, 600, 400, true, SceneAntialiasing.BALANCED);
    scene.setFill(Color.BISQUE);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Qubit3D Sample");
    primaryStage.show();

    qubit.rotateRod(rotate);

}