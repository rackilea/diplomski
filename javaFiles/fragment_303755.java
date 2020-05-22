for(TextField textField : textFields) {
    if(validateTextField(textField)) {
        //JOptionPane.showMessageDialog(null, textField.getText() + " Empty value");
        System.out.println(textField.getName() + " has an Empty value");
    }
}