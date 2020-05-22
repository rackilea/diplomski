int returnVal = JOptionPane.showConfirmDialog(PARENT_WINDOW, "Some message", "Title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
if (returnVal == JOptionPane.CANCEL_OPTION) {
    // do something if user cancels.
    return;
}

// user pressed confirm(ok)
... handle user input