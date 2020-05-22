import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class InsetsAndBorder extends JFrame {
    public InsetsAndBorder() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("insets 2 2 2 2, fillx, debug", "3[]3[]3[]3", "5[]5[]5[]5"));

        JLabel label1 = new JLabel("1");
        JLabel label2 = new JLabel("2");

        JButton button = new JButton("No way!");

        panel.add(label1, "cell 1 2, grow");

        panel.add(label2, "cell 2 2, grow");

        panel.add(button, "cell 0 1, grow");

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                InsetsAndBorder frame = new InsetsAndBorder();

            }

        });
    }
}