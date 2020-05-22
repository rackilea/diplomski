public static ArrayList<String> PetNames() { //<-- remove "static" from this line
    System.out.println(textField_3.getText().toString());
    petTexts.add(textField_3.getText().toString());
    petTexts.add(textField_4.getText());
    petTexts.add(textField_5.getText());
    petTexts.add(textField_6.getText());
    petTexts.add(textField_7.getText());
    petTexts.add(textField_8.getText());
    petTexts.add(textField_9.getText());
    petTexts.add(textField_10.getText());
    petTexts.add(textField_11.getText());
    return petTexts;
}