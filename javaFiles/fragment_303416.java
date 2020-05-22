import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Test extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }

    private static void constructGUI() {
        JFrame frame = new JFrame("Testy");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setPreferredSize(new Dimension(100, 400));
        frame.add(centerPanel, BorderLayout.CENTER);

        Test eastPanel = new Test();
        frame.add(eastPanel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    public Test() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Dimension d = new Dimension(50, 50);

        JButton button1 = new JButton("");
        button1.setPreferredSize(d);

        ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/Pictures/ellipse.png");

        button1.setIcon(imageIcon);

        button1.setMaximumSize(new Dimension(Integer.MAX_VALUE, button1.getMinimumSize().height));
        add(button1);

        JButton button2 = new JButton("");
        button2.setPreferredSize(d);

        button2.setIcon(imageIcon);

        button2.setMaximumSize(new Dimension(Integer.MAX_VALUE, button2.getMinimumSize().height));
        add(button2);

        JButton button3 = new JButton("");
        button3.setPreferredSize(d);

        button3.setIcon(imageIcon);

        button3.setMaximumSize(new Dimension(Integer.MAX_VALUE, button3.getMinimumSize().height));
        add(button3);

        add(Box.createVerticalGlue());

    }

}