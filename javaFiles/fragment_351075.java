protected void setValue(Object value) {
    try {
        String text = MyFormatter.format(value);            
        if (errorState) {
            updateUI(); // call setBackground(null) and properly repaint()
            errorState = false;
        }
        setText(text);
    } catch (IllegalArgumentException e) {
        // store error state:
        errorState = true;
        // Something is not quite right, indicate the error to the user:
        setBackground(Color.red);
        super.setValue(value);
    }
}