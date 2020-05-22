public void actionPerformed(final ActionEvent event) {
        Object newValue = null;
        if (event != null) {
            try {
                newValue = new Integer(event.getActionCommand());
            } catch (NumberFormatException e) {
            }
        }
        performAction(event, StyleConstants.FontSize, null, defaultValue,
                      newValue, false);
    }