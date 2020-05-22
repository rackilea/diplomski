import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TicTacToePlayer {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    private int count = 0;

    public static void main(String[] args) {
        new TicTacToePlayer();
    }

    public TicTacToePlayer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // create board
                final LinesComponent boardLines = new LinesComponent();
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(boardLines);
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class LinesComponent extends JComponent {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            draw(g2);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public void draw(Graphics2D g2) {
            Line2D.Double leftVertLine = new Line2D.Double(150, 50, 150, 350);
            Line2D.Double rightVertLine = new Line2D.Double(250, 50, 250, 350);
            Line2D.Double topHorizLine = new Line2D.Double(50, 150, 350, 150);
            Line2D.Double bottomHorizLine = new Line2D.Double(50, 250, 350, 250);
            g2.draw(leftVertLine);
            g2.draw(rightVertLine);
            g2.draw(topHorizLine);
            g2.draw(bottomHorizLine);
        }
    }
}