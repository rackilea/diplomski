import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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

        private final int limit = 100;
        private List<DropLet> droplets = new ArrayList<>(limit);

        public TestPane() {
            for (int index = 0; index < limit; index++) {
                droplets.add(new DropLet(150, 675));
            }
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Iterator<DropLet> it = droplets.iterator();
                    while (it.hasNext()) {
                        DropLet dropLet = it.next();
                        if (dropLet.update(675)) {
                            it.remove();
                        }
                    }
                    while (droplets.size() < limit) {
                        droplets.add(new DropLet(150, 150));
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1000, 1000);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            setBackground(Color.darkGray);

            g2d.setColor(Color.gray);
            g2d.fillOval(100, 100, 75, 25);
            g2d.fillOval(115, 115, 75, 25);
            g2d.fillOval(115, 85, 75, 25);
            g2d.fillOval(165, 75, 75, 25);
            g2d.fillOval(165, 125, 75, 25);
            g2d.fillOval(205, 115, 75, 25);
            g2d.fillOval(205, 85, 75, 25);
            g2d.fillOval(220, 100, 75, 25);
            g2d.fillOval(160, 95, 80, 35);

            g2d.setColor(Color.gray);
            g2d.fillOval(300, 100, 75, 25);
            g2d.fillOval(315, 115, 75, 25);
            g2d.fillOval(315, 85, 75, 25);
            g2d.fillOval(365, 75, 75, 25);
            g2d.fillOval(365, 125, 75, 25);
            g2d.fillOval(405, 115, 75, 25);
            g2d.fillOval(405, 85, 75, 25);
            g2d.fillOval(420, 100, 75, 25);
            g2d.fillOval(360, 95, 80, 35);

            g2d.setColor(Color.gray);
            g2d.fillOval(500, 100, 75, 25);
            g2d.fillOval(515, 115, 75, 25);
            g2d.fillOval(515, 85, 75, 25);
            g2d.fillOval(565, 75, 75, 25);
            g2d.fillOval(565, 125, 75, 25);
            g2d.fillOval(605, 115, 75, 25);
            g2d.fillOval(605, 85, 75, 25);
            g2d.fillOval(620, 100, 75, 25);
            g2d.fillOval(560, 95, 80, 35);

            g2d.setColor(Color.gray);
            g2d.fillOval(700, 100, 75, 25);
            g2d.fillOval(715, 115, 75, 25);
            g2d.fillOval(715, 85, 75, 25);
            g2d.fillOval(765, 75, 75, 25);
            g2d.fillOval(765, 125, 75, 25);
            g2d.fillOval(805, 115, 75, 25);
            g2d.fillOval(805, 85, 75, 25);
            g2d.fillOval(820, 100, 75, 25);
            g2d.fillOval(760, 95, 80, 35);

            g2d.setColor(Color.black);
            g2d.fillRect(0, 590, 1000, 100);

            g2d.setColor(Color.white);

            for (int i = 0; i <= 900; i = i + 150) {
                g2d.fillRect(30 + i, 625, 100, 25);
            }

            g2d.setColor(new Color(139, 69, 19));

            g2d.fillOval(100, 600, 35, 15);
            g2d.fillOval(300, 600, 30, 10);
            g2d.fillOval(500, 600, 25, 10);
            g2d.fillOval(700, 600, 35, 15);
            g2d.fillOval(125, 650, 35, 15);
            g2d.fillOval(175, 650, 35, 15);
            g2d.fillOval(230, 670, 35, 15);
            g2d.fillOval(280, 640, 35, 15);
            g2d.fillOval(340, 630, 35, 9);
            g2d.fillOval(400, 650, 35, 19);
            g2d.fillOval(450, 610, 35, 10);
            g2d.fillOval(500, 610, 35, 18);
            g2d.fillOval(600, 675, 35, 17);
            g2d.fillOval(700, 675, 25, 15);
            g2d.fillOval(710, 675, 30, 15);
            g2d.fillOval(770, 623, 40, 15);
            g2d.fillOval(690, 655, 25, 15);
            g2d.fillOval(830, 660, 25, 15);
            g2d.fillOval(810, 670, 23, 15);
            g2d.fillOval(880, 613, 29, 15);

            for (DropLet dropLet : droplets) {
                dropLet.paint(g2d);
            }

            g2d.dispose();
        }

        public class DropLet {
            private Point location;
            private int yDelta;

            public DropLet(int from, int to) {
                location = new Point(100 + (int)(Math.random() * 800), from + (int)(Math.random() * (to - from)));
                yDelta = (int)(Math.random() * 5) + 1;
            }

            public boolean update(int range) {
                location.y += yDelta;
                return location.y > range;
            }

            public void paint(Graphics2D g2d) {
                g2d.setColor(Color.CYAN);
                g2d.fillOval(location.x - 3, location.y - 3, 6, 6);
            }

        }

    }
}