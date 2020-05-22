public class Foo extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawString("hello", 0, 20);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Foo");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.add(new Foo());
    frame.pack();
    frame.setVisible(true);
  }
}