import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
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

    public static class TestPane extends JPanel {

        private String[] maze = {
            "..........#S##........",
            "..........##.#........",
            "...........#.#........",
            ".............#........",
            ".....##......#........",
            "....#####.###.........",
            "#####.###.#####.......",
            "....###.########......",
            "......####.####.......",
            "......####..###.......",
            "......#####..###......",
            "......#####...##......",
            "......######..........",
            ".......######.........",
            ".......######.........",
            ".......#######........",
            "........#######.......",
            "........###...........",
            "........###...........",
            "......................",
        };

        protected static final int CELL_SIZE = 10;

        public TestPane() {
            setBackground(Color.DARK_GRAY);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(22 * CELL_SIZE, 21 * CELL_SIZE);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int y = 0;
            for (String line : maze) {
                int x = 0;
                for (char element : line.toCharArray()) {
                    switch (element) {
                        case '.': 
                            paintSpace(g2d, x, y);
                            break;
                        case '#': 
                            paintHash(g2d, x, y);
                            break;
                        case 'S': 
                            paintStart(g2d, x, y);
                            break;
                    }
                    x += CELL_SIZE;
                }
                y += CELL_SIZE;
            }
            g2d.dispose();
        }

        protected void paintSpace(Graphics2D g2d, int x, int y) {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        }

        protected void paintHash(Graphics2D g2d, int x, int y) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        }

        protected void paintStart(Graphics2D g2d, int x, int y) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
            g2d.setColor(Color.RED);
            g2d.fillOval(x, y, CELL_SIZE, CELL_SIZE);
        }
    }

}