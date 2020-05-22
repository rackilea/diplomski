public class NonogramSolutionJFrame extends JFrame {
  private final JLabel label;
  private final JPanel panel;

  public NonogramSolutionJFrame(BufferedImage img) {
    panel = new JPanel();
    label = new JLabel();
    initComponents(img);
  }

  private final void initComponents(BufferedImage img) {
    setTitle("Background Color for JFrame");
    setBackgroundImage(img);
    setContentPane(panel);
    panel.setLayout(new BorderLayout());
    panel.add(label, BorderLayout.CENTER);
    setLocationRelativeTo(null);
    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void setBackgroundImage(final BufferedImage img) {
    label.setIcon(new ImageIcon(img));
    label.setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
  }

  public static void main(String... args) throws Exception {
    BufferedImage img = ImageIO.read(NonogramSolutionJFrame.class.getResource("/nonogram.png"));
    NonogramSolutionJFrame frame = new NonogramSolutionJFrame(img);
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        frame.setVisible(true);
      }
    });
  }
}