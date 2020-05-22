import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ShowMain {
    private static void createAndShowGui() {
        MainPanel mainPanel = new MainPanel();
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        CreateActionPanel actionPanel = new CreateActionPanel();
        new Controller(actionPanel, mainPanel);

        JFrame frame = new JFrame("ShowMain");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(actionPanel, BorderLayout.PAGE_START);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class MainPanel extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = 80;

    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }

    public MainPanel() {
        setBorder(BorderFactory.createTitledBorder("Main Panel"));
    }

    public void addButtonAction(Action action) {
        add(new JButton(action));

        // so the button will be displayed properly
        revalidate();
        repaint();
    }
}

class Controller {
    public Controller(final CreateActionPanel actionPanel, final MainPanel mainPanel) {
        actionPanel.addPropertyChangeListener(CreateActionPanel.ACTION_NAME, pcEvt -> {
            mainPanel.addButtonAction(new AbstractAction((String) pcEvt.getNewValue()) {
                {
                    int mnemonic = (int) pcEvt.getNewValue().toString().charAt(0);
                    putValue(MNEMONIC_KEY, mnemonic);
                }

                @Override
                public void actionPerformed(ActionEvent evt) {
                    System.out.printf("Button %s pressed!%n", evt.getActionCommand());
                }
            });
        });
    }
}

class CreateActionPanel extends JPanel {
    public static final String ACTION_NAME = "action name";
    private JTextField actionNameField = new JTextField(10);

    public CreateActionPanel() {
        actionNameField.addActionListener((e -> {
            String text = actionNameField.getText();
            firePropertyChange(ACTION_NAME, null, text);
            actionNameField.selectAll();
        }));

        add(new JLabel("Button Text to Add:"));
        add(actionNameField);
    }
}