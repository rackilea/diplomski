import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Box> boxes = new ArrayList<Box>(2);

        public TestPane() {
            boxes.add(new Box(Color.BLUE, 0, 0));
            boxes.add(new Box(Color.RED, 50, 50));

            setLayout(new BorderLayout());

            JButton flip = new JButton("Flip");
            flip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ok, this is a cheat as I only have to boxes,
                    // if you had more, you'd need to move the box you 
                    // higher in the rendering order closer to the end 
                    // of the list
                    Collections.reverse(boxes);
                    repaint();
                }
            });
            add(flip, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(150, 150);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Cheat, I should looping over the box array to calculate the
            // area the boxes actuall occupy
            int x = (getWidth() - 150) / 2;
            int y = (getHeight() - 150) / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.translate(x, y);

            for (Box box : boxes) {
                box.paint(g2d);
                x += 50;
                y += 50;
            }
            g2d.dispose();
        }
    }

    public class Box {

        private Color color;

        private int x, y;

        public Box(Color color, int x, int y) {
            this.color = color;
            this.x = x;
            this.y = y;
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillRect(x, y, 100, 100);
        }
    }

}