import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class largest extends Applet implements ActionListener{
    private static final long serialVersionUID = 1L;

    private int counter = 0; // These are the variables
    private double largest = 0; // from actionPerformed().

    // ...

    public void actionPerformed(ActionEvent e) {
        // Variable for user input
        double number = 0;

        try { //Sanitize user input, make sure input entered is a number
            number = Double.parseDouble(numberField.getText());
        } catch (NumberFormatException ex) {
            numberField.requestFocus();
            JOptionPane.showMessageDialog(null,
                    "Input invalid, please enter an integer",
                    "///-D-A-T-A---E-R-R-O-R-\\\\\\",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (number < 0 || number > 9) { //Sanitize user input, make sure the given number is between 0 and 9
            numberField.requestFocus();
            JOptionPane.showMessageDialog(null,
                    "The number entered must be between 0 and 9",
                    "///-D-A-T-A---E-R-R-O-R-\\\\\\",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        counter++;
        // Determine what the largest number entered is by comparing to a baseline
        // of previous numbers or zero if just beginning loop
        if (number > largest)largest=number;
        // Allows user to input 10 times
        if (counter==10)
        {
            // Display's the largest number that got entered by user
            JOptionPane.showMessageDialog(null,
                    "The largest number entered was " + largest);
        }
    }
}