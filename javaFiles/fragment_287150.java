import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame { // The JFrame is the window
    JTextField textField; // The textField

    public GUI() {
        textField = new JTextField(10); // The user can enter 10 characters into the textField
        textField.addActionListener(new ActionListener() { // This will listen for actions to be performed on the textField (enter button pressed)

            @Override
            public void actionPerformed(ActionEvent e) { // Called when the enter button is pressed
                // TODO Auto-generated method stub
                String inputText = textField.getText(); // Get the textField's text
                textField.setText(""); // Clear the textField
                System.out.println(inputText); // Print out the text (or you can do something else with it)
            }
        });

        JPanel panel = new JPanel(); // Make a panel to be displayed
        panel.add(textField); // Add the textField to the panel
        this.add(panel); // Add the panel to the JFrame (we extend JFrame)

        this.setVisible(true); // Visible
        this.setSize(500, 500); // Size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit when the "x" button is pressed
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}