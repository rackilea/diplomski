import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                frame.add(new MainPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class MainPanel extends JPanel {

        public static final int NODE_SIZE = 32;
        public static final int BOARD_SIZE = 8;

        private int row, col = -1;

        public MainPanel() {

            // listen to mouse clicks
            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    System.out.println("mouseX: " + mouseX + " mouseY: " + mouseY);

                    // get the row and column clicked
                    int row = mouseY / NODE_SIZE;
                    int col = mouseX / NODE_SIZE;

                    if (row > BOARD_SIZE - 1 || col > BOARD_SIZE - 1) { // avoid out of bounds
                        return;
                    }

                    System.out.println("row: " + row + " col: " + col);

                    repaint();
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    row = mouseY / NODE_SIZE;
                    col = mouseX / NODE_SIZE;
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(BOARD_SIZE * NODE_SIZE, BOARD_SIZE * NODE_SIZE);
        }

        /**
         * Custom painting codes on this JPanel Called by repaint()
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);    // fills background
            setBackground(Color.WHITE); // sets background color

            g.setColor(Color.GREEN);

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (row == j && col == i) {
                        g.setColor(Color.RED);
                        g.fillRect(NODE_SIZE * i, NODE_SIZE * j, NODE_SIZE, NODE_SIZE);
                    }
                    g.setColor(Color.BLACK);
                    g.drawRect(NODE_SIZE * i, NODE_SIZE * j, NODE_SIZE, NODE_SIZE);
                }
            }
        }
    }
}