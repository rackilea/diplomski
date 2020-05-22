public class House extends Canvas{

  House(){
    setSize(800,600);
  }
  public void paint(Graphics g){

    Polygon p = new Polygon();
    p.addPoint(100,50);
    p.addPoint(300,50);
    p.addPoint(250,100);
    p.addPoint(50,100);

    g.fillPolygon(p);

    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(new Color(0xAEAEAE));
    g2.draw(new Line2D.Double(300, 50, 350, 100));
    g2.draw(new Line2D.Double(350, 100, 350, 180));
    g2.draw(new Line2D.Double(350, 180, 250, 180));
    g.setColor(new Color(0xFFEABB));
    p = new Polygon();
    p.addPoint(50,100);
    p.addPoint(250,100);
    p.addPoint(250,180);
    p.addPoint(50,180);

    g.fillPolygon(p);

    g.setColor(new Color(0xFFFFFF));
    p = new Polygon();
    p.addPoint(75,125);
    p.addPoint(225,125);
    p.addPoint(225,150);
    p.addPoint(75,150);

    g.fillPolygon(p);

    }
  }