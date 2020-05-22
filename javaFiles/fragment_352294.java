@Override
public void start(Stage primaryStage) {
    Group root = new Group();

    // bending curve
    Rectangle srcRect1 = new Rectangle(100, 100, 50, 50);
    Rectangle dstRect1 = new Rectangle(300, 300, 50, 50);

    CubicCurve curve1 = new CubicCurve(125, 150, 125, 225, 100, 325, 300, 325);
    curve1.setStroke(Color.BLACK);
    curve1.setStrokeWidth(1);
    curve1.setFill(null);

    final double ARROW_LENGTH = 15;
    final double ARROW_ANGLE = 45;

    // the transform for the rotation arrow rotation
    Rotate rotation = new Rotate(ARROW_ANGLE);

    // direction = inwards from the start point
    Point2D tan = new Point2D(
            curve1.getControlX1() - curve1.getStartX(),
            curve1.getControlY1() - curve1.getStartY()
    ).normalize().multiply(ARROW_LENGTH);

    Path arrowIni = new Path();

    // move to start point of curve
    MoveTo move = new MoveTo(curve1.getStartX(), curve1.getStartY());

    // transform tangent by rotating with +angle
    Point2D p = rotation.transform(tan);

    LineTo a1 = new LineTo(p.getX(), p.getY());
    // position relative to end point
    a1.setAbsolute(false);

    // same as above, but in oposite direction
    rotation.setAngle(-ARROW_ANGLE);
    p = rotation.transform(tan);
    LineTo a2 = new LineTo(p.getX(), p.getY());
    a2.setAbsolute(false);

    arrowIni.getElements().addAll(move, a1, move, a2);

    // direction = inwards from the end point
    tan = new Point2D(
            curve1.getControlX2() - curve1.getEndX(),
            curve1.getControlY2() - curve1.getEndY()
    ).normalize().multiply(ARROW_LENGTH);
    move = new MoveTo(curve1.getEndX(), curve1.getEndY());
    p = rotation.transform(tan);
    a1 = new LineTo(p.getX(), p.getY());
    a1.setAbsolute(false);
    rotation.setAngle(ARROW_ANGLE);
    p = rotation.transform(tan);
    a2 = new LineTo(p.getX(), p.getY());
    a2.setAbsolute(false);

    Path arrowEnd = new Path();
    arrowEnd.getElements().addAll(move, a1, move, a2);

    root.getChildren().addAll(srcRect1, dstRect1, curve1, arrowIni, arrowEnd);

    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.show();
}