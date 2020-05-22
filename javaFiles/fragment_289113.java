public static void main(String[] args) {
    String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
    int response = JOptionPane.showOptionDialog(null, "Message", "Title",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, options, options[0]);

    // Where response == 0 for Yes, 1 for No, 2 for Maybe and -1 or 3 for Escape/Cancel.
}