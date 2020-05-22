public enum ButtonState {
  ONE, TWO, THREE;
  public void update(Robot robot) {
    if (robot == null) return;
    if (this == ONE) {
      robot.mousePress(InputEvent.BUTTON1_MASK);
    } else if (this == TWO) {
      robot.mousePress(InputEvent.BUTTON3_MASK);
    } else {
      robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
    }
  }
}

public static void pressMouse(ButtonState button) {
  try {
    Robot robot = new Robot();
    button.update(robot);
  } catch(Exception e) {
    e.printStackTrace();
  }
}