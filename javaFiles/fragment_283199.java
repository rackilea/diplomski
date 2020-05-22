public class myPanel extends JPanel{

  private int[] xTri;
  private int[] yTri;

  public myPanel(int[] xTri, int[] yTri) {
      this.xTri = xTri;
      this.yTri = yTri;
  }

  public void paint (int [] numbers, Graphics g) {
                super.paint (g);
                g.setColor (Color.BLACK);
                g.fillPolygon (xTri, yTri, xTri.length);
  }
}