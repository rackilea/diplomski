import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestGUI extends JFrame {

    public TestGUI() {

        JPanel bigPanel = new JPanel(new GridBagLayout());
        JPanel panel_a = new JPanel();
        JButton btnA = new JButton("button a");
        panel_a.add(btnA);

        JPanel panel_b = new JPanel();
        JButton btnB = new JButton("button b");
        panel_b.add(btnB);

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        bigPanel.add(panel_a, c);
        bigPanel.add(panel_b, c);
        c.weighty = 1.0;
        // Temporary panel to fill the rest of the bigPanel
        bigPanel.add(new JPanel(), c);
        this.add(bigPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestGUI gui = new TestGUI();
                gui.pack();
                gui.setVisible(true);
            }
        });
    }
}