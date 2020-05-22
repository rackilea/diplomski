Platform.runLater(new Runnable() {
    @Override
    public void run() {
        // ...
        Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
        // ...
        robot.mouseMove(x, 5);
    }
});