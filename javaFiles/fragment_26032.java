import datetest.CircleShort.ControlPanel;
import datetest.CircleShort.CreateCircle;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class CircleShort extends JFrame {

    CreateCircle p1 = new CreateCircle();

    public CircleShort() {
        CreateCircle p1 = new CreateCircle();
        JFrame main = new JFrame();
        main.setSize(new Dimension(600, 600));
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        Container c = main.getContentPane();
        main.add(p1);
        JFrame control = new JFrame();
        control.setTitle("Control Panel");
        control.setSize(new Dimension(300, 300));
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        control.setLocationRelativeTo(main);
        control.setVisible(true);

        ControlPanel p2 = new ControlPanel(p1);
        control.add(p2);

    }

    static class CreateCircle extends JComponent {

        int circleX = 100;
        Ellipse2D.Double circle;

        public CreateCircle() {
            circle = new Ellipse2D.Double(circleX, 50, 400, 350);
        }

        public void setCircleX(int x) {
            circleX = x;
            circle = new Ellipse2D.Double(circleX, 50, 400, 350);
            repaint();
        }

        public int getCircleX() {
            return circleX;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);
            g2.fill(circle);
        }
    }

    class ControlPanel extends JComponent {

        private CreateCircle circle;

        public ControlPanel(CreateCircle value) {
            circle = value;
            setLayout(new GridLayout(4, 0));
            JButton change = new JButton("Click");
            add(change);
            JLabel info = new JLabel("Click Above To Change Color",
                    JLabel.CENTER);
            add(info);
            JLabel info1 = new JLabel("Slide Below To Change Size",
                    JLabel.CENTER);
            add(info1);
            JScrollBar slider = new JScrollBar(Scrollbar.HORIZONTAL, 0, 100, 0,
                    300);
            add(slider);
            slider.addAdjustmentListener(new AdjustmentListener() {

                public void adjustmentValueChanged(AdjustmentEvent e) {
                    System.out.println(e.getValue());
                    circle.setCircleX((circle.getCircleX() + (e.getValue() % 5)));
                }

            });

        }
    }

    static class CircleRun {

        public static void main(String[] args) {
            new CircleShort();
        }
    }
}