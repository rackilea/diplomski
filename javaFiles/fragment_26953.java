import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomLeftLabel extends JLabel {

    public static BottomLeftLabel BLP;  
    public static BufferedImage original;
    public static ImageIcon icon;
    public static Polygon poly;
//  public static JLabel label;

    public BottomLeftLabel() throws IOException {
        super();

//      this.setBackground(new Color(255, 255, 255, 0));

        original = Methods2.loadImage("crash bandicoot picture.jpg");
//      original = Methods2.loadImage("bowser jr.png");
//      original = Methods2.loadImage("devil's tooth.jpg");
        original = Methods2.toFourChannel(original);
//      int[][] p = Methods.toIntegerArray(original);
//      p = Methods.adjustTransparency(p, (float) 1.0);
//      original = Methods.toBufferedImage(p);
//      this.setSize(new Dimension(original.getWidth(), original.getHeight()));
//      Graphics g = this.getGraphics();
        poly = null;
        icon = new ImageIcon(original);
//      label = new JLabel(icon);

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                Point2D P = me.getPoint();
                if(poly == null) {
                    poly = new Polygon(new int[]{(int) P.getX()}, new int[]{(int) P.getY()}, 1);
                    return;
                }
                int[] B = poly.xpoints;
                int[] C = poly.ypoints;
                int[] X = new int[poly.npoints + 1];
                int[] Y = new int[poly.npoints + 1];
                System.arraycopy(B, 0, X, 0, B.length);
                System.arraycopy(C, 0, Y, 0, C.length);
                X[B.length] = (int) P.getX();
                Y[C.length] = (int) P.getY();
                poly = new Polygon(X, Y, poly.npoints + 1);
                System.out.println(poly.toString());
//              BLP.getGraphics().clearRect(0, 0, BLP.getHeight(), BLP.getWidth());
//              BLP.removeAll();
//              icon = new ImageIcon(original);
//              BLP.add(new JLabel(icon));
                BLP.paint(BLP.getGraphics());
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        this.setIcon(icon);
        BLP = this;
//      repaint(this.getGraphics());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        if(poly != null) {
            g.drawPolygon(poly);
        }
    }

//  /**
//   *
//   * @param g
//   */
//  public void repaint(Graphics g) {
////        g.clearRect(0, 0, WIDTH, HEIGHT);
//
//      g.setColor(Color.black);
//      g.drawPolygon(poly);
//      this.removeAll();
//      icon = new ImageIcon(original);
//      this.add(new JLabel(icon));
//  }

//  public void repaint(Graphics g) {
//      
//  }

}