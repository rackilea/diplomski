import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SnakeGame {
    private JFrame frame;
    private Snake snake;
    private JPanel buttonsPane;
    private JButton[] buttons; // Our array of buttons
    private Timer timer;
    private Direction currentDirection;

    // This enum will be used to determine the direction the snake will take.
    private enum Direction {
        TOP, LEFT, BOTTOM, RIGHT
    }

    public static void main(String[] args) {
        // We place our program on the EDT using Java 8 lambda expressions.
        SwingUtilities.invokeLater(() -> new SnakeGame().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame(getClass().getSimpleName());
        snake = new Snake();
        buttonsPane = new JPanel();
        buttons = new JButton[Direction.values().length];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(Direction.values()[i].toString()); // We create a JButton with the current value of the direction
            buttons[i].addActionListener(listener); // We set their ActionListeners
            buttonsPane.add(buttons[i]); // And add them to the buttonsPane
        }

        currentDirection = Direction.RIGHT; // We set a default direction
        timer = new Timer(1000, listener); // And start our Swing Timer

        // We add our components and then pack the frame, after that we start the timer.
        frame.add(snake);
        frame.add(buttonsPane, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        timer.start();
    }

    // Our ActionListener for moving the snake
    private ActionListener listener = e -> { // Using Java 8 lambda expressions again
        // We set the current direction using a ternary, if the source of the event is
        // the timer we leave the current direction as is
        // otherwise we set it to the direction from the button clicked
        currentDirection = e.getSource().equals(timer) ? currentDirection : Direction.valueOf(e.getActionCommand());
        snake.move(currentDirection); // And we call the move method
    };

    @SuppressWarnings("serial")
    class Snake extends JPanel {
        private int xPos;
        private int yPos;
        private static final int SPEED = 10; // We set the speed as a constant (10 pixels at a time) in any direction

        // We determine the movement direction
        public void move(Direction direction) {
            switch (direction) {
            case TOP:
                yPos -= SPEED;
                break;
            case LEFT:
                xPos -= SPEED;
                break;
            case BOTTOM:
                yPos += SPEED;
                break;
            case RIGHT:
                xPos += SPEED;
                break;
            }
            this.repaint(); // And repaint the snake
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.DARK_GRAY);
            g2d.fill(new Rectangle2D.Double(xPos, yPos, 10, 10)); // We draw a rectangle using the Shape API
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300); // We set the preferredSize of the JPanel to 300 x 300
        }
    }
}