import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FooGui {
    public static void main(String[] args) {
        new MainFrame();
    }
}

class MainFrame extends JFrame {
    JFrame Frame1;

    public MainFrame() {
        Frame1 = new JFrame();
        Frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Frame1.getContentPane().add(new ParentPanel(), BorderLayout.CENTER);
        Frame1.setSize(800, 600);
        Frame1.setLocationRelativeTo(null);
        Frame1.pack();
        Frame1.setVisible(true);
    }
}

// Class ParentPanel:
class ParentPanel extends JPanel {
    private JPanel ParentPanel;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;

    public ParentPanel() {
        ParentPanel = new JPanel();
        leftPanel = new LeftPanel(new String[] {RP1Panel.NAME, RP2Panel.NAME});
        rightPanel = new RightPanel();
        ParentPanel.setLayout(new GridLayout(1, 2));
        ParentPanel.add(leftPanel);
        ParentPanel.add(rightPanel);
        add(ParentPanel);

        // !!
        leftPanel.comboAddActionListener(e -> {
            String selection = leftPanel.getComboSelection();
            rightPanel.showCard(selection);
        });
    }
}

// Class LeftPanel:
class LeftPanel extends JPanel {
    private JPanel leftPanel;
    private JComboBox<String> comboBox; //!!

    // !!
    public LeftPanel(String[] comboTexts) {
        leftPanel = new JPanel();
        comboBox = new JComboBox<>(comboTexts); // !!
        leftPanel.add(comboBox);
        add(leftPanel);
    }

    // !!
    public String getComboSelection() {
        return comboBox.getSelectedItem().toString();
    }

    // !!
    public void comboAddActionListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }
}

// Class RightPanel:
class RightPanel extends JPanel {
    private JPanel rightPanel;
    private RP1Panel rightPanel1;
    private RP2Panel rightPanel2;
    private CardLayout cardLayout;

    public RightPanel() {
        rightPanel = new JPanel();
        rightPanel1 = new RP1Panel();
        rightPanel2 = new RP2Panel();
        cardLayout = new CardLayout();
        rightPanel.setLayout(cardLayout);
        rightPanel.add(rightPanel1, RP1Panel.NAME); //!!
        rightPanel.add(rightPanel2, RP2Panel.NAME);  // !!
        cardLayout.show(rightPanel, RP1Panel.NAME); // !!
        add(rightPanel);
    }

    // !! 
    public void showCard(String name) {
        cardLayout.show(rightPanel, name);
    }
}

// Class RP1Panel:
class RP1Panel extends JPanel {
    // !!
    public static final String NAME = "right panel 1";
    private JPanel RP1;
    private JLabel JRP1;

    public RP1Panel() {
        setName(NAME);
        RP1 = new JPanel();
        JRP1 = new JLabel("RP1 Panel");
        RP1.add(JRP1);
        add(RP1);
    }
}

// Class RP2Panel:
class RP2Panel extends JPanel {
    // !!
    public static final String NAME = "right panel 2";
    private JPanel RP2;
    private JLabel JRP2;

    public RP2Panel() {
        setName(NAME);
        RP2 = new JPanel();
        JRP2 = new JLabel("RP2 Panel");
        RP2.add(JRP2);
        add(RP2);
    }
}