Object[] options = { "OK", "CANCEL" };
JOptionPane.showOptionDialog(
    null,
    "Click OK to continue", 
    "Warning",
    JOptionPane.DEFAULT_OPTION,
    JOptionPane.WARNING_MESSAGE,
    null,
    options,  // available options
    options[0]); // default option