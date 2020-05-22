public static void AddArray(ArrayList arrayWords, JTextField textFieldEntry, JLabel labelWords){

    Pattern p = Pattern.compile("[a-zA-Z-]+");
    Matcher m = p.matcher(textFieldEntry.getText());
    if (m.matches()){
        arrayWords.add(textFieldEntry.getText());
        labelWords.setText("'"+textFieldEntry.getText()+"' was added to list.");
    }
    else{
        labelWords.setText("The string ‘"+textFieldEntry.getText()+"’ was not added to the list as it is not a valid word.");
    }
}