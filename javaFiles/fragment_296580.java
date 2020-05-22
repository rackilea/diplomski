// initializing Integer interpretation
Integer input = null;
// infinite loop - breaks only once user has entered a valid integer-parseable value
while (true) {
    // trying to convert user input after showing option pane
    try {
        input = Integer.valueOf(JOptionPane.showInputDialog(null, "X = "));
        // breaking infinite loop
        break;
    }
    // conversion unsuccessful
    catch (NumberFormatException nfe) {
        // TODO handle any error message if you need to
    }
}