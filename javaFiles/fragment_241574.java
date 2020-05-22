JOptionPane optionPane = new JOptionPane("File haven't save yet." +
            " \n Are you want to save the file?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
    JDialog dialog = optionPane.createDialog("Confirm Dialog");
    Set<AWTKeyStroke> focusTraversalKeys = new HashSet<AWTKeyStroke>(dialog.getFocusTraversalKeys(0));
    focusTraversalKeys.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_RIGHT, KeyEvent.VK_UNDEFINED));
    dialog.setFocusTraversalKeys(0, focusTraversalKeys);
    dialog.setVisible(true);
    dialog.dispose();
    int option = (Integer) optionPane.getValue();