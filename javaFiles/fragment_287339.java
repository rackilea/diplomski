import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestRobot02 {

    public static void main(String[] args) {
        new TestRobot02();
    }

    public TestRobot02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                TestRobot02.TestPane testPane = new TestRobot02.TestPane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(testPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                new Thread(new TestRobot02.RobotThread(testPane)).start();

            }
        });
    }

    public class RobotThread implements Runnable {

        private TestPane component;
        private Robot autoPlay;

        private RobotThread(TestPane component) {
            this.component = component;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestRobot02.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                autoPlay = new Robot();

                autoPlay.setAutoDelay(500);
                autoPlay.mouseMove((component.getLocationOnScreen().x + 1), (component.getLocationOnScreen().y + 1));
                autoPlay.mousePress(InputEvent.BUTTON1_MASK);
                autoPlay.mouseRelease(InputEvent.BUTTON1_MASK);
                autoPlay.mouseMove((component.getLocationOnScreen().x + component.getWidth() - 1), (component.getLocationOnScreen().y));
                autoPlay.mousePress(InputEvent.BUTTON1_MASK);
                autoPlay.mouseRelease(InputEvent.BUTTON1_MASK);
                autoPlay.mouseMove((component.getLocationOnScreen().x + 1), (component.getLocationOnScreen().y + component.getHeight() - 1));
                autoPlay.mousePress(InputEvent.BUTTON1_MASK);
                autoPlay.mouseRelease(InputEvent.BUTTON1_MASK);
                autoPlay.mouseMove((component.getLocationOnScreen().x + component.getWidth() - 1), (component.getLocationOnScreen().y + component.getHeight() - 1));
                autoPlay.mousePress(InputEvent.BUTTON1_MASK);
                autoPlay.mouseRelease(InputEvent.BUTTON1_MASK);

                Component child = component.getComponent(0);
                Point pos = child.getLocationOnScreen();
                Dimension size = child.getSize();
                pos.x += size.width / 2;
                pos.y += size.height / 2;
                autoPlay.mouseMove(pos.x, pos.y);
                autoPlay.mousePress(InputEvent.BUTTON1_MASK);
                autoPlay.mouseRelease(InputEvent.BUTTON1_MASK);

                //                autoPlay.mouseMove(currentX, currentY);
            } catch (AWTException exp) {
                exp.printStackTrace();
            }
        }
    }

    public class TestPane extends JPanel {

        public TestPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Mouse Clicked at " + e.getPoint());
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    System.out.println("Mouse Pressed at " + e.getPoint());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("Mouse Released at " + e.getPoint());
                }

            });

            setLayout(new GridBagLayout());
            JButton btn = new JButton("Click me");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("I was clicked :D");
                }
            });
            add(btn);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
}