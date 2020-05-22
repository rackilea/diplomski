private Path path;
private double x1, y1;

@Override
public void start(Stage primaryStage) {

    AnchorPane root = new AnchorPane();

    root.addEventHandler(MouseEvent.ANY, e -> {
        if(e.getTarget() instanceof Path){
            // Select existing path
            Path path1 = (Path)e.getTarget();

            if (e.getEventType() == MouseEvent.MOUSE_ENTERED_TARGET) {
                path1.setEffect(new DropShadow(20, Color.BLACK));
            } else if (e.getEventType() == MouseEvent.MOUSE_EXITED_TARGET) {
                path1.setEffect(null);
            } else if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
                x1=e.getX(); 
                y1=e.getY();
            } else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                // traslate path
                path1.setTranslateX(e.getX()-x1+path1.getTranslateX());
                path1.setTranslateY(e.getY()-y1+path1.getTranslateY());
                x1=e.getX(); 
                y1=e.getY();
            } else if (e.getButton()==MouseButton.SECONDARY) {
                // right-click over the path to move it to its original position
                path1.setTranslateX(0);
                path1.setTranslateY(0);
            }
        } else {
            // Generate new path
            if (e.getEventType() == MouseEvent.MOUSE_PRESSED) {
                path = new Path();
                path.setStroke(Color.BLACK);
                path.setStrokeWidth(10);
                path.getElements().add(new MoveTo(e.getX(), e.getY()));
                root.getChildren().add(path);
            } else if (e.getEventType() == MouseEvent.MOUSE_DRAGGED || 
                e.getEventType() == MouseEvent.MOUSE_RELEASED) {
                path.getElements().add(new LineTo(e.getX(), e.getY()));
            }
        }
    });

    Scene scene = new Scene(root, 600, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}