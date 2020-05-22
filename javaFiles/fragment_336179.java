import java.awt.GridLayout;
import javax.swing.*;

public class StackingLabels extends JPanel {
    public static final String[] TEXTS = { "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday" };

    public StackingLabels() {
        setLayout(new GridLayout(0, 1));
        for (String text : TEXTS) {
            add(new JLabel(text));
        }
    }

    private static void createAndShowGui() {
        StackingLabels mainPanel = new StackingLabels();

        JFrame frame = new JFrame("StackingLabels");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
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