import java.awt.BasicStroke;
    import java.awt.Dimension;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.RenderingHints;
    import java.awt.geom.Ellipse2D;
    import java.awt.geom.PathIterator;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;

    public class Outline extends JPanel {

       JFrame       frame = new JFrame();
       PathIterator iter;

       public static void main(String[] args) {
          SwingUtilities.invokeLater(() -> new Outline().start());
       }

       public void start() {
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.add(this);
          setPreferredSize(new Dimension(500, 500));
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
          demo();
       }

       public void demo() {
          double smajAxis = 200;
          double sminAxis = 100;
          Ellipse2D.Double oval = new Ellipse2D.Double(250 - smajAxis / 2,
                            250 - sminAxis / 2, smajAxis, sminAxis);
          iter = oval.getPathIterator(null, .02);
          repaint();

       }
       public void paintComponent(Graphics g) {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;
          g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
          g2d.setStroke(new BasicStroke(2));
          double[] start = new double[2];
          double[] end = new double[2];
          iter.currentSegment(start);
          int x1 = (int) start[0];
          int y1 = (int) start[1];
          int savex1 = x1;
          int savey1 = y1;
          iter.next();
          while (!iter.isDone()) {
             iter.currentSegment(end);
             int x2 = (int) end[0];
             int y2 = (int) end[1];
             g2d.drawLine(x1, y1, x2, y2);
             x1 = x2;
             y1 = y2;
             iter.next();
          }
          g2d.drawLine(x1, y1, savex1, savey1);

       }
    }