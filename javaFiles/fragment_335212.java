public class Main {

public static void main(String[] args) throws InterruptedException {
    final RobotCommand pressAKeyCommand = new PressAKeyCommand();
    Thread t = new Thread(new Runnable() {

        public void run() {
            pressAKeyCommand.execute();
        }
    });
    t.start();
    Thread.sleep(5000);
    pressAKeyCommand.stop();

  }
}

class PressAKeyCommand implements RobotCommand {

private volatile boolean isContinue = true;

public void execute() {
    try {
        Robot robot = new Robot();
        while (isContinue) {
            robot.keyPress(KeyEvent.VK_A);
        }
        robot.keyRelease(KeyEvent.VK_A);
    } catch (AWTException ex) {
        // Do something with Exception
    }
}

  public void stop() {
     isContinue = false;
  }
}

interface RobotCommand {

  void execute();

  void stop();
}