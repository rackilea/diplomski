@Override
    public void start(Stage stage) {
        stage.setTitle(VersionInfo.getRuntimeVersion());
        Group root = new Group();

        // ellypsis with center in 100,100
        Arc ellypsis = ArcBuilder.create().centerX(100).centerY(100).length(360).radiusX(100).radiusY(50).fill(Color.TRANSPARENT).stroke(Color.RED).build();
        // rotate
        ellypsis.getTransforms().add(new Rotate(50, 50, 45));

        // find out where is 100,100 in rotated ellypsis
        Point2D localToParent = ellypsis.localToParent(100,100);

        // draw line from that point
        Line line = new Line(localToParent.getX(), localToParent.getY(), 200, 200);
        root.getChildren().addAll(ellypsis, line);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }