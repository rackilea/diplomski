MaskFormatter dateMask;
try {
    dateMask = new MaskFormatter("##/##/####");
    dateMask.setPlaceholderCharacter('/');
    dateMask.setValidCharacters("0123456789");
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
textF = new JFormattedTextField(dateMask ); 
textF.setHorizontalAlignment(JTextField.RIGHT);