import javax.swing.JOptionPane;

public class Excercise613 {
    // Display the prompt to the user; wait for the user to enter a whole number; 
    // return it.  
    public static int askInt(String prompt) {    
        String s = JOptionPane.showInputDialog(prompt);
        Double d = Double.parseDouble(s);                     
        return d >= 0 ? (int) d.doubleValue() : (int) (d.doubleValue() - 1);
    } // End of method
} // End of class