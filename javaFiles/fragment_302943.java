public class Koch extends JComponent
{
  int depth = 4;
  Point2D[] pts;

  public Koch(int w, int h)
  {
    setSize(w, h);
    pts = new Point2D[] {
        new Point2D.Double(w/8, 3*h/4),
        new Point2D.Double(w-w/8, 3*h/4),
        new Point2D.Double(w/2, 3*h/4 - Math.sqrt(3)*3*h/8)
    };
  }

  private void drawSide(Path2D p, double x2, double y2, int depth)
  {
    if(depth == 0)
    {
      p.lineTo(x2,  y2);;
      return;
    }    

    double x1 = p.getCurrentPoint().getX(); 
    double y1 = p.getCurrentPoint().getY();     
    double x3 = x1+(x2-x1)/3;
    double y3 = y1+(y2-y1)/3;
    double x4 = x1+2*(x2-x1)/3; 
    double y4 = y1+2*(y2-y1)/3;
    double cx = x3+(x4-x3)/2 - Math.sqrt(3)*(y4-y3)/2; 
    double cy = y3+(y4-y3)/2 + Math.sqrt(3)*(x4-x3)/2;   

    p.lineTo(x3, y3);
    drawSide(p, cx, cy, depth-1);
    drawSide(p, x4, y4, depth-1);
    p.lineTo(x2, y2);
  }

  public void paintComponent(Graphics g1)
  {
    g1.setColor(Color.WHITE);
    g1.fillRect(0, 0, getWidth(), getHeight());

    Graphics2D g = (Graphics2D)g1;
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);    
    g.setColor(Color.BLUE);

    Path2D p = new Path2D.Double();
    p.moveTo(pts[0].getX(), pts[0].getY());
    drawSide(p, pts[1].getX(), pts[1].getY(), depth);
    drawSide(p, pts[2].getX(), pts[2].getY(), depth);
    drawSide(p, pts[0].getX(), pts[0].getY(), depth);
    g.draw(p);
  }

  public Dimension getPreferredSize()
  {
    return getSize();
  }

  public static void main(String[] args)
  {
    JFrame f = new JFrame("Koch Curve");    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new Koch(400, 400));
    f.pack();
    f.setVisible(true);
  }
}