public static class IntegerField extends JTextField {
    public IntegerField(String txt) {
        super(txt);
        setDocument(new IntegerDocument());
    }

    public int getInt() {
        return this.getText().equals("") ? 0 : Integer.parseInt(this.getText());        
    }
}