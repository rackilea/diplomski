import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GridBagExample {
    private JPanel leftPanel;
    private JPanel rightPanel;

    private GridBagConstraints gbc;
    private Random random;

    public GridBagExample() {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);

        random = new Random();
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = getPanel();
        contentPane.setLayout(new GridBagLayout());
        leftPanel = getPanel();
        rightPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return (new Dimension(100, 100));
            }
        };

        addComp(contentPane, leftPanel, 0, 0, 1, 1,
                    GridBagConstraints.BOTH, 1.0, 1.0);
        addComp(contentPane, rightPanel, 1, 0, 1, 1,
                    GridBagConstraints.NONE, 0.0, 1.0);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void addComp(JPanel panel, JComponent comp, int gridx,
                            int gridy, int gridwidth, int gridheight,
                                int fill, double weightx, double weighty) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;

        panel.add(comp, gbc);
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(new Color(random.nextInt(256),
                            random.nextInt(256), random.nextInt(256)));

        return panel;
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new GridBagExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}