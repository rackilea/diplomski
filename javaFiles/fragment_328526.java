public class SnakeFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  private SnakeCanvas c;// 410x310

  public SnakeFrame() {
    c = new SnakeCanvas();
    c.setPreferredSize(new Dimension(410, 310));
    c.setVisible(true);
    c.setFocusable(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.add(c);
  }

  public static void main(String[] args) {
    Runnable doRun = new Runnable() {
      @Override
      public void run() {
        SnakeFrame sf = new SnakeFrame();
        sf.setSize(new Dimension(410, 310));
        sf.setVisible(true);
      }
    };
    new Thread(doRun).start();
  }
}