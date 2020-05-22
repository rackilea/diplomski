String username = null;
do {
    username = JOptionPane.showInputDialog(null, "Please enter a username");
    // check if the username is invalid
    if(username.length() > 12 || username.length() < 4 || !username.matches("[a-zA-Z0-9]+")) {
        // show the user why they cant enter that username
        JOptionPane.showMessageDialog(null, "Username must be:\nbetween 4 and 12 characters characters\nonly letters and numbers", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
        // do the loop again
        username = null; 
    }
} while(username == null);
// at this point in the execution we can say that the username String is a valid username