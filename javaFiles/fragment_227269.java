import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class TestScreenshot {

    static JLabel screenshot;

    public static void main(String[] args) throws Exception {
        final Robot robot = new Robot();
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                final JFrame f = new JFrame("Screenshot");

                JPanel gui = new JPanel(new BorderLayout(3,3));

                gui.setBorder(new EmptyBorder(5,5,5,5));

                f.setContentPane(gui);

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                screenshot = new JLabel();
                JScrollPane scroll = new JScrollPane(screenshot);
                scroll.setPreferredSize(new Dimension(800,600));
                gui.add(scroll, BorderLayout.CENTER);

                final ActionListener al = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        Rectangle screenSize = new Rectangle(
                            Toolkit.getDefaultToolkit().getScreenSize());
                        Image image = robot.createScreenCapture(screenSize);
                        setImage(image);
                        f.setVisible(true);
                    }
                };

                JButton grabScreen = new JButton("Grab Screen");
                grabScreen.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        f.setVisible(false);
                        Timer timer = new Timer(400, al);
                        timer.setRepeats(false);
                        timer.start();
                    }
                } );
                gui.add(grabScreen, BorderLayout.SOUTH);

                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    }

    public static void setImage(Image image) {
        screenshot.setIcon(new ImageIcon(image));
    }
}