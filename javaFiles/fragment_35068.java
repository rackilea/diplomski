import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test extends JFrame {

    public static void main(String[] args) {
        new Test();
    }

    public Test() throws HeadlessException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Test");
                frame.add(new TestPane());
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        ArrayList<Line2D> lines = new ArrayList<>();

        public TestPane() {
            drawCircle(3, 3.0, 3.0);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(Color.RED);
            System.out.println(lines.size());
            for (Line2D s : lines) {
                g2d.draw(s);
            }
            g2d.dispose();
        }

        public void drawCircle(int radio, double xCenter, double yCenter) {
            double t = 0;
            double xPoint;
            double yPoint;
            double xActual = xCenter;
            double yActual = yCenter + radio * Math.sin(0);
            t += 0.01;

            while (t < 360) {
                xPoint = xCenter + radio * Math.cos(t);
                yPoint = yCenter + radio * Math.sin(t);

//              System.out.println(xActual + "x" + yActual + "x" + xPoint + "x" + yPoint);
                lines.add(new Line2D.Double(xActual, yActual, xPoint, yPoint));

                t += 0.01;
                xActual = xPoint;
                yActual = yPoint;
            }
        }
    }

}