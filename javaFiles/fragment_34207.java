import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MouseTest {

    public static void main(String[] args) {
        new MouseTest();
    }

    public MouseTest() {
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

        public TestPane() {
            setLayout(null);
            JPanel panel = new JPanel();
            panel.setBackground(Color.RED);
            panel.setSize(50, 50);
            panel.setLocation(50, 50);
            add(panel);

            MouseAdapter ma = new MouseAdapter() {
                private Point offset;
                private Point clickPoint;
                private JPanel clickedPanel;

                @Override
                public void mousePressed(MouseEvent e) {
                    // Get the current clickPoint, this is used to determine if the
                    // mouseRelease event was part of a drag operation or not
                    clickPoint = e.getPoint();
                    // Determine if there is currently a selected panel or nor
                    if (clickedPanel != null) {
                        // Move the selected panel to a new location
                        moveSelectedPanelTo(e.getPoint());
                        // Reset all the other stuff we might other was have set eailer
                        offset = null;
                        clickedPanel = null;
                    } else {
                        // Other wise, find which component was clicked
                        findClickedComponent(e.getPoint());
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Check to see if the current point is equal to the clickedPoint
                    // or not.  If it is, then this is part of a "clicked" operation
                    // meaning that the selected panel should remain "selected", otherwise
                    // it's part of drag operation and should be discarded
                    if (!e.getPoint().equals(clickPoint)) {
                        clickedPanel = null;
                    }
                    clickPoint = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    // Drag the selected component to a new location...
                    if (clickedPanel != null) {
                        moveSelectedPanelTo(e.getPoint());
                    }
                }

                protected void findClickedComponent(Point p) {
                    Component comp = getComponentAt(p);
                    if (comp instanceof JPanel && !comp.equals(TestPane.this)) {
                        clickedPanel = (JPanel) comp;
                        int x = p.x - clickedPanel.getLocation().x;
                        int y = p.y - clickedPanel.getLocation().y;
                        offset = new Point(x, y);
                    }

                }

                private void moveSelectedPanelTo(Point p) {
                    if (clickedPanel != null) {
                        int x = p.x - offset.x;
                        int y = p.y - offset.y;
                        System.out.println(x + "x" + y);
                        clickedPanel.setLocation(x, y);
                    }
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}