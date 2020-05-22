import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class EventDrivenGui extends JPanel {
    private static final int FIELD_SIZE = 10;
    private static final int SELECTED_FIELD_SIZE = 4;
    protected static final Color SELECTED_COLOR = Color.PINK;
    private JButton btnStraight;
    private JTextArea textArea = new JTextArea(20, 40);
    private List<JTextField> selectedFieldList = new ArrayList<>();
    private List<JTextField> fieldList = new ArrayList<>();

    public EventDrivenGui() {
        btnStraight = new JButton("Straight");
        btnStraight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedFieldList.size() > 0) {
                    return;
                }
                for (JTextField textField : fieldList) {
                    textField.setEnabled(true);
                }
                JOptionPane.showMessageDialog(btnStraight, "Please Select a text field",
                        "Make Selection", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        textArea.setFocusable(false);

        JPanel fieldPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        for (int i = 0; i < FIELD_SIZE; i++) {
            JTextField field = new JTextField("Field " + (i + 1), 10);
            field.setEnabled(false); // so they can't select it prematurely
            fieldList.add(field);
            fieldPanel.add(field);

            field.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    JTextField tf = (JTextField) e.getComponent();
                    if (!selectedFieldList.contains(tf)) {

                        textArea.append(tf.getText() + "\n");
                        tf.setBackground(SELECTED_COLOR);
                        selectedFieldList.add(tf);
                        if (selectedFieldList.size() >= SELECTED_FIELD_SIZE) {
                            if (RouletteHelperMethods.doBet("Straight") == 1) {
                                textArea.append("Congrats, you won!\n");
                            } else {
                                textArea.append("Sorry, you lost.\n");
                            }

                            reset();
                        }
                    }

                }
            });

        }

        add(btnStraight);
        add(new JScrollPane(textArea));
        add(fieldPanel);
    }

    protected void reset() {
        selectedFieldList.clear();
        for (JTextField jTextField : fieldList) {
            jTextField.setEnabled(false);
            jTextField.setBackground(null);
        }
    }

    private static void createAndShowGui() {
        EventDrivenGui mainPanel = new EventDrivenGui();

        JFrame frame = new JFrame("EventDrivenGui");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class RouletteHelperMethods {

    public static int doBet(String bet) {
        return Math.random() > 0.5 ? 1 : 0;
    }

}