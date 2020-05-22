public class FrameA extends JFrame {

  public void setSomeDate() {
  }
}

public class FrameB extends JFrame {

  public void doSomething() {
    FrameA frameA = new FrameA();
    frameA.setSomeDate();
  }
}