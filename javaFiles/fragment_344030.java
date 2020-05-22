final JLabel l = new JLabel(" ");
JTextField field = new JTextField();
field.setInputVerifier(new InputVerifier() {

    @Override
    public boolean verify(JComponent arg0) {
        Boolean b = ((JTextField)arg0).getText().length() == 11;
        if(!b){
            l.setText("error");
        } else {
            l.setText("accepted");
        }
        return b;
    }
});