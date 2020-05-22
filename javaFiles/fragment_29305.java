import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MenuAction {

    public static void main(final String args[]) throws AWTException {

        ActionListener menuListener = new MenuActionListener();

        JFrame frame = new JFrame("MenuSample Example");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        // File Menu, F - Mnemonic
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        // File->New, N - Mnemonic
        JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
        newMenuItem.addActionListener(menuListener);
        fileMenu.add(newMenuItem);

        frame.setJMenuBar(menuBar);
        frame.setSize(650, 650);

        JButton button = new JButton("Test");
        frame.getContentPane().add("South", button);
        frame.setBounds(100, 100, 400, 400);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                button.requestFocusInWindow();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Robot robot = new Robot();

                            robot.setAutoDelay(500);

                            robot.waitForIdle();

                            robot.keyPress(KeyEvent.VK_ALT);

                            robot.keyPress(KeyEvent.VK_F);
                            robot.keyRelease(KeyEvent.VK_F);
                            robot.keyRelease(KeyEvent.VK_ALT);
                            robot.waitForIdle();
                        } catch (AWTException exp) {
                            exp.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        frame.setVisible(true);
    }

    public static class MenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {

            System.out.println("Selected: " + actionEvent.getActionCommand());

        }
    }
}