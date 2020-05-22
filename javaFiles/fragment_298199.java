class IntegerVerifier extends InputVerifier {
    String lastGood = "";
    public boolean verify(JComponent input) {
        JTextField text = (JTextField)input;
        String value = text.getText().trim();
        try {
            Integer.parseInt(value);
            lastGood = value;
        } catch (NumberFormatException e) {
            text.setText(lastGood);
            // assumed it should return false
           return false;
        }
        return true;
    }
}