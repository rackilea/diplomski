t1.addFocusListener(new FocusListener() {

    @Override
    public void focusGained(FocusEvent e) {
        t1.setText(null); // Empty the text field when it receives focus
    }

});