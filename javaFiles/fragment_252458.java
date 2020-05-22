import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class VertBoxes extends JPanel {
    private static final String[] LABEL_TEXTS = { "A", "One", "Two", "Monday",
            "Tuesday", "January", "Fourth of July",
            "Four score and seven years ago" };
    public static final int PREF_W = 260;
    public static final int PREF_H = 80;

    public VertBoxes() {
        setLayout(new GridLayout(0, 1, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        for (String labelTxt : LABEL_TEXTS) {
            add(new InnerBox(labelTxt));
        }
    }

    private class InnerBox extends JPanel {
        public InnerBox(String labelTxt) {
            setLayout(new GridBagLayout());
            setBorder(BorderFactory.createLineBorder(Color.black, 4));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JButton("Button"), gbc);
            gbc.gridy++;
            add(new JLabel(labelTxt), gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            if (isPreferredSizeSet()) {
                return super.getPreferredSize();
            }
            return new Dimension(PREF_W, PREF_H);
        }
    }

    private static void createAndShowGui() {
        VertBoxes mainPanel = new VertBoxes();

        JFrame frame = new JFrame("Vertical Boxes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}