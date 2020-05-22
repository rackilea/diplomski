class Bullseye extends JPanel {
  static final int SIZE = 300; // initial window size
  int rings = 3; // Number of rings to draw in bullseye

  public Bullseye() {
    this.setBackground(Color.white);
    this.setPreferredSize(new Dimension(SIZE, SIZE));
  }

  public void setRings(int r) {
    rings = r;
    this.repaint(); // new value of rings - better repaint
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // x,y coordinate of top left corner for drawing circles
    int x = SIZE / 2;
    int y = SIZE / 2;

    for (int i = rings; i > 0; i--) {
      if (i % 2 == 0)
        g.setColor(Color.white);
      else
        g.setColor(Color.red);
      int radius = i * 100 / rings; // compute radius of this ring
      g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
  }
}