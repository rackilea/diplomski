import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
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
                frame.add(new JLabel("Hello"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        move(frame, 100, 100);
                    }
                });
            }
        });
    }

    public static void move(JFrame frame, int deltaX, int deltaY) {
        int xMoveBy = deltaX > 0 ? 4 : -4;
        int yMoveBy = deltaY > 0 ? 4 : -4;

        int targetX = frame.getX() + deltaX;
        int targetY = frame.getY() + deltaY;

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int frameX = frame.getX();
                int frameY = frame.getY();
                if (deltaX > 0) {
                    frameX = Math.min(targetX, frameX + xMoveBy);
                } else {
                    frameX = Math.max(targetX, frameX - xMoveBy);
                }
                if (deltaY > 0) {
                    frameY = Math.min(targetY, frameY + yMoveBy);
                } else {
                    frameY = Math.max(targetY, frameY - yMoveBy);
                }

                frame.setLocation(frameX, frameY);
                if (frameX == targetX && frameY == targetY) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

}