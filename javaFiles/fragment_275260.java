public void start(Stage primaryStage) throws Exception {

    // Choose a Object to move around the Path
    Circle objectCircle = new Circle();
           objectCircle.setRadius(10);

    // Use a Shape for the Path or...
    Circle pathCircle = new Circle(300, 200, 150);
           pathCircle.setFill(null);
           pathCircle.setStroke(Color.BLACK);

    // ...use different approach (see createEllipsePath below) or...
    Path path = createEllipsePath(400, 200, 150, 150, 0);

    // ...use Class MoveTo & CubicCurveTo
    //path.getElements().add (new MoveTo (0f, 50f));
    //path.getElements().add(new CubicCurveTo(40f, 10f, 390f, 240f, 1904, 50f));

    // Set up a Path Transition
    PathTransition pathTransitionCircle = new PathTransition();
                   pathTransitionCircle.setDuration(Duration.seconds(10));
                   pathTransitionCircle.setNode(objectCircle);
                   pathTransitionCircle.setPath(pathCircle);
                   pathTransitionCircle.setCycleCount(Timeline.INDEFINITE);
                   pathTransitionCircle.setAutoReverse(false);
                   pathTransitionCircle.setInterpolator(Interpolator.LINEAR);
                   pathTransitionCircle.play();

    BorderPane root = new BorderPane();
               root.getChildren().addAll(pathCircle,objectCircle);

    // Pause Transition
    root.setOnMousePressed(eve -> pathTransitionCircle.pause());

    // Set up the ScrollEvent
    root.setOnScroll(event -> {

        //SCROLL UP
        double currentTime = pathTransitionCircle.getCurrentTime().toMillis();
        double jumpRate = 100; // change rate for smaller/bigger jumps
        pathTransitionCircle.jumpTo(Duration.millis(currentTime + jumpRate));

        //SCROLL DOWN
        double deltaY = event.getDeltaY();
        if (deltaY < 0) {
            if (currentTime == 0) {
                currentTime = 10000; // end of circle is 10000millis: at second 0 we cannot jump to negative seconds, so we set it to 10000millis
                pathTransitionCircle.jumpTo(Duration.millis(currentTime - jumpRate));
            } else {
                pathTransitionCircle.jumpTo(Duration.millis(currentTime - jumpRate));
            }
        }
    });

    primaryStage.setTitle("Path Transition ScrollEvent");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
}

//create an EllipsePath with ArcTo
private Path createEllipsePath(double centerX, double centerY, double radiusX, double radiusY, double rotate) {

    ArcTo arcTo = new ArcTo();
          arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree circle
          arcTo.setY(centerY - radiusY);
          arcTo.setSweepFlag(false);
          arcTo.setLargeArcFlag(true);
          arcTo.setRadiusX(radiusX);
          arcTo.setRadiusY(radiusY);
          arcTo.setXAxisRotation(rotate);

    Path pathCircle = new Path();
         pathCircle.getElements().addAll(new MoveTo(centerX - radiusX, centerY - radiusY),arcTo);
         pathCircle.getElements().add(new ClosePath());

    // Styling
         pathCircle.setStroke(Color.RED);
         pathCircle.getStrokeDashArray().setAll(5d, 5d);

    return pathCircle;
}

public static void main(String[] args) { launch(args); }