import java.awt.Dimension;
import java.awt.event.ItemEvent;

import javax.swing.*;

public class GuiFun extends JPanel {
    private JCheckBox checkbox = new JCheckBox("Foo");

    public GuiFun() {
        setPreferredSize(new Dimension(300, 150));
        add(checkbox);
        checkbox.setSelected(false);
        checkbox.addItemListener(l -> {
            if (l.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("CheckBox SELECTED");
            } else {
                System.out.println("CheckBox UNSELECTED");
            }
        });
    }

    private static void createAndShowGui() {
        GuiFun mainPanel = new GuiFun();

        JFrame frame = new JFrame("Gui Fun");
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