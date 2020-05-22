import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem {
    public static void main(String[] args) {
        Snake snake = new Snake();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame gameWindow = new JFrame("Snake");
                snake.setPreferredSize(new Dimension(600, 600));
                gameWindow.add(snake);
                gameWindow.pack();
                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameWindow.setLocationRelativeTo(null);
                gameWindow.setVisible(true);
            }
        });
    }

    private static class Snake extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.drawOval(549, 549, 50, 50);
        }
    }