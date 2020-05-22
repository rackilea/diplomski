String input = JOptionPane.showInputDialog("Please enter a number");
try {
    int n = Integer.parseInt(input);
    // ....
} catch (NumberFormatException e) {
    // Exception when input is not in integer format
    // or is null when user press cancel button
}