import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TextDemo extends JPanel implements ActionListener {
    private JTextField textField;
    private String text;

    public TextDemo() {
        super(new GridBagLayout());

        textField = new JTextField(20); // Here 20 gives a hint on the width of the textfield
        textField.addActionListener(this);

        // Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        text = textField.getText();
    }

    public static void main(String[] args) {
        // Create and set up the window.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("TextDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Add contents to the window.
                frame.add(new TextDemo());

                // Display the window.
                frame.pack();
                frame.setMinimumSize(frame.getPreferredSize());
                frame.setVisible(true);

            }
        });
    }
}