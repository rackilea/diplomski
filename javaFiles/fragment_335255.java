/* Update the scene every 40 milliseconds. */
final Robot robot = new Robot();
Timer timer = new Timer(40, (e) -> {
    robot.mouseRelease(0); //some event
    updateScene();
});
timer.start();