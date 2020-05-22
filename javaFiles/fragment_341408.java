import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingABall extends JFrame {

    private JButton jbtLeft = new JButton("Left");
    private JButton jbtRight = new JButton("Right");
    private JButton jbtUp = new JButton("Up");
    private JButton jbtDown = new JButton("Down");
    private BallPanel ballPanel = new BallPanel();

    public MovingABall () {
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(jbtLeft);
        buttonPanel.add(jbtRight);
        buttonPanel.add(jbtUp);
        buttonPanel.add(jbtDown);

        ballPanel.setBackground(Color.RED);
        this.add(ballPanel);
        this.add(buttonPanel, BorderLayout.SOUTH);
        jbtLeft.addActionListener(new ButtonListener());
        jbtRight.addActionListener(new ButtonListener());
        jbtUp.addActionListener(new ButtonListener());
        jbtDown.addActionListener(new ButtonListener());
    }

    public static void main(String[] args) {
        // Should be called on the EDT!
        MovingABall mainWondow = new MovingABall();
        mainWondow.setTitle("Moving a ball");
        mainWondow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Don't pack here.  Instead return a preferred size for the
        // custom comonent end..
        //mainWondow.setSize(300, 200);
        // ..pack() the window.
        mainWondow.pack();
        mainWondow.setVisible(true);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent buttonPressed) {
            if (buttonPressed.getSource() == jbtLeft)
                ballPanel.left();
            else if (buttonPressed.getSource() == jbtRight)
                ballPanel.right();
            else if (buttonPressed.getSource() == jbtUp)
                ballPanel.up();
            else if (buttonPressed.getSource() == jbtDown)
                ballPanel.down();
        }
    }

    class BallPanel extends JPanel {
        private int xCoord = -1;
        private int yCoord = -1;
        private Dimension preferredSize = new Dimension(300,200);

/*  Harmful to our logic..
        public BallPanel() {
            xCoord = getWidth()/2;
            yCoord = getHeight()/2;
            repaint();
        }
*/
/*  A good compiler would remove this..
        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);
        } */

        public void left() {
            xCoord-=5;
            repaint();
        }

        public void right() {
            xCoord+=5;
            repaint();
        }
        public void up() {
            yCoord-=5;
            repaint();
        }

        public void down() {
            yCoord+=5;
            repaint();
        }

        /** Suggest a size to the layout manager. */
        @Override
        public Dimension getPreferredSize() {
            return preferredSize;
        }

        protected void paintComponent(Graphics aBall) {
            super.paintComponent(aBall);
            // This will center the ball if it is the first time painted
            // OR if the x or y co-ord goes off the left/top edge.
            // Further logic left to user..
            if (xCoord<0 || yCoord<0) {
                xCoord = getWidth()/2;
                yCoord = getHeight()/2;
            }
            System.out.println("X" + getWidth());
            aBall.drawOval(xCoord, yCoord, 10, 10);
        }
    }
}