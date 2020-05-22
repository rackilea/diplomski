String text = "Press OK to get a frame";
    String title = "Show Frame";
    int optionType = JOptionPane.OK_CANCEL_OPTION;
    int result = JOptionPane.showConfirmDialog(null, text, title, optionType);
    if (result == JOptionPane.OK_OPTION) {
        //...
    }