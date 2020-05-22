public void start(Stage primaryStage) throws Exception {
        GlassRobot robot = new GlassRobotImpl();
        Point2D point = robot.getMouseLocation();
        double x = point.getX();
        double y = point.getY();
        System.out.println("y = " + y);
        System.out.println("x = " + x);
        if(x > 10) {
              primaryStage.show();
       }
public static void main(String[] args) {
        launch(args);
    }