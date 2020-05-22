public class PingPong extends JPanel {

  private static final long serialVersionUID = 7048642004725023153L;

  Ball ball = new Ball();

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    ball.paint(g);
  }

  public static void main(String[] args) {
    /* Creating the frame */
    JFrame frame = new JFrame();
    frame.setTitle("Ping Pong!");
    frame.setSize(600, 600);
    frame.setBounds(0, 0, 600, 600);
    frame.getContentPane().setBackground(Color.darkGray);
    frame.add(new PingPong());
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

}