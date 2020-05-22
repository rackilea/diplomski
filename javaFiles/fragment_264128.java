public class CircleDraw extends JPanel {
  private int radius;
  private double s;
  private double area;
  private Random rand = new Random(); // make this a field

  // call this when you want to change the random images
  public void randomizeDrawing() {
     center1X = rand.nextInt(507);
     center1Y = rand.nextInt(320);
     center2X = rand.nextInt(507);
     center2Y = rand.nextInt(320);
     center3X = rand.nextInt(507);
     center3Y = rand.nextInt(320);
     repaint();
  }

  // and only do painting in paintComponent
  @Override
  protected void paintComponent(Graphics g) {
     super.paintComponent(g);

     // draw the 3 circles
     g.drawOval(center1X, center1Y, 100, 100);
     g.drawOval(center2X, center2Y, 100, 100);
     g.drawOval(center3X, center3Y, 100, 100);

     // connect the centers of the circles with lines
     g.drawLine(center1X + 50, center1Y + 50, center2X + 50, center2Y + 50);
     g.drawLine(center2X + 50, center2Y + 50, center3X + 50, center3Y + 50);
     g.drawLine(center3X + 50, center3Y + 50, center1X + 50, center1Y + 50);
  }