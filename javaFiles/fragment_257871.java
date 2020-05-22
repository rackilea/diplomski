import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.*;

public class TestInternalFrame {

    private static void createAndShowUI() {
        JDesktopPane pane = new JDesktopPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 200);
            }
        };
        pane.setBackground(Color.WHITE);

        addFrame(pane, new Point(50, 20), "Window1");
        addFrame(pane, new Point(60, 30), "Window2");
        addIcon(pane, new Point(5, 5), "Action", 
                UIManager.getIcon("OptionPane.informationIcon"));

        JFrame frame = new JFrame("Desktop");
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private static void addFrame(JDesktopPane pane, Point p, String title) {
        JInternalFrame frame = new JInternalFrame(title);
        frame.setSize(200, 100);
        frame.setLocation(p);
        frame.setResizable(true);
        frame.setMaximizable(true);
        frame.setIconifiable(true);
        frame.setClosable(true);
        frame.setVisible(true);
        pane.add(frame);
    }

    private static void addIcon(JDesktopPane pane, Point p, String text, Icon icon) {
        JButton button = new JButton(text, icon);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setBounds(new Rectangle(p, button.getPreferredSize()));
        pane.add(button);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    createAndShowUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}