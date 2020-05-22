package log;

import javax.swing.JOptionPane;

public class Login {

    public static void main(String args[]) {

        String username = JOptionPane.showInputDialog("Enter your username");
        String password = JOptionPane.showInputDialog("Enter your password");

        if (username != null && password != null
                && ((username.equals("gkic17") && password.equals("irena46"))
                        || (username.equals("dm") && password.equals("me21mar"))
                        || (username.equals("citizenzap") && password.equals("guestboy19")))) {
            JOptionPane.showMessageDialog(null, "Logged in!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password! Try again later.");
        }
    }
}