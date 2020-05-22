JTextArea text = ...;
text.addFocusListener(new FocusListener() {
    public void focusGained(FocusEvent e) {}
    public void focusLost(FocusEvent e) {
        // Load your content.
    }

});