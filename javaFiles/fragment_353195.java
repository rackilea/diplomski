import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private RegularPolygonPanel polyPanel;
        private JLabel label;

        public TestPane() {
            polyPanel = new RegularPolygonPanel();
            polyPanel.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (polyPanel.isWithinPolygon(e.getPoint())) {
                        label.setText("Is inside");
                    } else {
                        label.setText("Is outside");
                    }
                }
            });
            label = new JLabel("...");
            setLayout(new BorderLayout());
            add(polyPanel);
            add(label, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    class RegularPolygonPanel extends JPanel {

        private Polygon polygon;

        public RegularPolygonPanel() {
            //Create a Polygon object
            polygon = new Polygon();

            polygon.addPoint(40, 20);
            polygon.addPoint(70, 40);
            polygon.addPoint(60, 80);
            polygon.addPoint(45, 45);
            polygon.addPoint(20, 60);
        }

        public boolean isWithinPolygon(Point p) {
            return polygon.contains(p);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            //Draw the polygon
            g.drawPolygon(polygon);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
}