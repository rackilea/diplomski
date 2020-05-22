import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    private JPanel testPanel = new JPanel(new GridBagLayout()), testPanel2 = new JPanel(new GridBagLayout());
    private GridBagConstraints c = new GridBagConstraints();
    private JLabel label1 = new JLabel("Something"), label2 = new JLabel("Something Else");

    Test() {
        super("Example Frame");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildGUI();

        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        add(testPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        add(testPanel2, c);

        pack();
        setVisible(true);
    }

    private void buildGUI() {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        testPanel.add(label1, c);

        testPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        c.gridx = 0;
        c.gridy = 0;
        testPanel2.add(label2, c);
    }

    public static void main(String[] args) {
        new Test();
    }
}