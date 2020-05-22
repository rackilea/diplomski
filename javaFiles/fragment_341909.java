import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestLabelButton extends JPanel {

    public TestLabelButton() {
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(1, 0, 10, 10));

        for (int i = 0; i < 4; i++) {
            add(new LabelButton("Text " + (i + 1)));
        }
    }

    private static void createAndShowGui() {
        TestLabelButton mainPanel = new TestLabelButton();

        JFrame frame = new JFrame("TestLabelButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}