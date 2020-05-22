import java.awt.Color;
    import java.awt.GradientPaint;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.geom.Line2D;
    import java.awt.geom.Point2D;
    import java.awt.geom.Rectangle2D;
    import javax.swing.JComponent;
    import javax.swing.JFrame;
    class GradientPane extends JComponent {
      public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Point2D.Float p1 = new Point2D.Float(150.f, 75.f); // Gradient line start
        Point2D.Float p2 = new Point2D.Float(250.f, 75.f); // Gradient line end
        float width = 300;
        float height = 50;
        Rectangle2D.Float rect1 = new Rectangle2D.Float(p1.x - 100, p1.y - 25, width, height);
        GradientPaint g2 = new GradientPaint(p1, Color.WHITE, p2, Color.DARK_GRAY, false); // Acyclic gradient

        rect1.setRect(p1.x - 100, p1.y - 25, width, height);
        g2D.setPaint(g2); // Gradient color fill
        g2D.fill(rect1); // Fill the rectangle
        g2D.setPaint(Color.BLACK); // Outline in black
        g2D.draw(rect1); // Fill the rectangle
        g2D.draw(new Line2D.Float(p1, p2));
      }
    }    
    public class AcyclicGradientPaint {
      public static void main(String[] a) {
         JFrame window = new JFrame("Acyclic Gradient Paint");
         window.setBounds(30, 30, 300, 300);
         window.getContentPane().add(new GradientPane());
         window.setVisible(true);
      }
    }