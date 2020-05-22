import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class SimpleGUI extends JFrame {

    private final JPanel firstPanel;
    private final JPanel secondPanel;
    private final JButton submitButton;
    private final JTextField textField;
    private final JLabel secondPanelLabel;

    public SimpleGUI() {

        // sets the title of the JFrame
        super("SimpleGUI");

        setLayout(new FlowLayout());

        // inits both JPanels
        firstPanel = new JPanel();
        secondPanel = new JPanel();

        // inits empty second JLabel and adds to the secondPanel
        secondPanelLabel = new JLabel();
        secondPanel.add(secondPanelLabel);

        // makes the secondPanel invisible for the time being
        secondPanel.setVisible(false);

        // inits the submit button
        submitButton = new JButton("Submit");

        // event-handler for submit button, will set the text in the
        // secondPanelLabel to the text in the JTextField the user types
        // into. It then makes the firstPanel (with the text field and button),
        // invisible, and then makes the second panel visible.
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondPanelLabel.setText(textField.getText());
                firstPanel.setVisible(false);
                secondPanel.setVisible(true);
            }
        });

        // inits the textField
        textField = new JTextField(10);

        // adds the button and the text field to the firstPanel
        firstPanel.add(submitButton);
        firstPanel.add(textField);

        // adds both panels to this JFrame
        this.add(firstPanel);
        this.add(secondPanel);
    }
}