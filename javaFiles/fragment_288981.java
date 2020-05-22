String text = textField.getText();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date textFieldAsDate = null;

try {
    textFieldAsDate = sdf.parse(text);
} catch (ParseException pe) {
    // deal with ParseException
}