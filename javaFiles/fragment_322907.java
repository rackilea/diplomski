import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DayPanel extends JPanel {

    public DayPanel() {
        super();
        setBackground(Color.CYAN);

        final JButton goodButton = new JButton("Good");
        final JButton badButton = new JButton("Bad");

        ActionListener listener = new DayPanel.ButtonsHandler();
        goodButton.addActionListener(listener);
        badButton.addActionListener(listener);

        add(goodButton);
        add(badButton);
    }

    class ButtonsHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            final String command = ((JButton) e.getSource()).getActionCommand();

            if (command.equals("Good")) {
                showMessage("Today is a good day!");
            } else if (command.equals("Bad")) {
                showMessage("Today is a bad day!");
            }
        }

        // Show popup message
        private void showMessage(String message) {
            JOptionPane.showMessageDialog(null, message,
                    "Event Handler Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}