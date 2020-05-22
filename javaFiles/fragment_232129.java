import javax.swing.*;
import java.awt.*;

public class Testing {

    private JFrame f = new JFrame("Main Frame");
    private JWindow splashScreen = new JWindow();

    public Testing() {
        splashScreen = new JWindow(f);
        splashScreen.getContentPane().setLayout(new GridBagLayout());
        JLabel label = new JLabel("Splash Screen");
        label.setFont(label.getFont().deriveFont(96f));
        splashScreen.getContentPane().add(label, new GridBagConstraints());
        splashScreen.pack();
        splashScreen.setLocationRelativeTo(null);
        splashScreen.setVisible(true);
        new Thread(new Runnable() {

            @Override
            public void run() {
                readDatabase();
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        createAndShowGUI();
                    }
                });
            }
        }).start();
    }

    public void readDatabase() {
        //simulate time to read/load data - 10 seconds?
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAndShowGUI() {
        JLabel label = new JLabel("My Frame");
        label.setFont(label.getFont().deriveFont(96f));
        f.add(label);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        System.out.println("JFrame getAccessibleChildrenCount count -> "
                + SwingUtilities.getAccessibleChildrenCount(f));
        System.out.println("JWindow getParent -> "
                + SwingUtilities.getWindowAncestor(splashScreen));
        splashScreen.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Testing t = new Testing();
            }
        });
    }
}