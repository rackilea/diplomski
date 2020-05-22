class MyDrawPanel extends JPanel {
  private static final int PREF_W = 1000;
  private static final int PREF_H = 300;

  public void paintComponent(Graphics g) {
     super.paintComponent(g); //!!   ******** don't forget this!!! *********
     Graphics2D g2 = (Graphics2D) g;
     g2.setColor(Color.white);
     for (int i = 0; i < 1000; i += 42) {
        g2.fill3DRect(i, 100, 20, 80, true);
     }
     g2.setColor(Color.black);
     for (int i = 21; i < 1000; i += 42) {
        g2.fill3DRect(i, 100, 20, 80, true);
     }
  }

  // the getPReferredSize will make this JPanel preferentially be this size
  @Override
  public Dimension getPreferredSize() {
     return new Dimension(PREF_W, PREF_H);
  }
}