import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestGridBagLayout {

    protected void initUI1() {
        final JFrame frame = new JFrame("Grid bag layout");
        frame.setTitle(TestGridBagLayout.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1 = new JLabel("L1");
        JLabel l2 = new JLabel("L2");
        JButton b = new JButton("B");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.add(l1, gbc);
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(b, gbc);
        gbc.weightx = 0;
        panel.add(l2, gbc);
        frame.add(panel);
        frame.setSize(800, 100);
        frame.setVisible(true);
    }

    protected void initUI2() {
        final JFrame frame = new JFrame("Border layout");
        frame.setTitle(TestGridBagLayout.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel l1 = new JLabel("L1");
        JLabel l2 = new JLabel("L2");
        JButton b = new JButton("B");
        JPanel wrappingPanel = new JPanel(new FlowLayout());
        wrappingPanel.add(b);
        panel.add(l1, BorderLayout.WEST);
        panel.add(l2, BorderLayout.EAST);
        panel.add(wrappingPanel);
        frame.add(panel);
        frame.setLocation(0, 125);
        frame.setSize(800, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestGridBagLayout test = new TestGridBagLayout();
                test.initUI1();
                test.initUI2();
            }
        });
    }

}