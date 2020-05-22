// initialize editor component
comboBox.addFocusListener(new FocusAdapter() {
    public void focusGained(FocusEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                comboBox.showPopup();
            }
        });
    }
});