public boolean isEqualToString(JTextField textField, String compareTo) {
     String text = textField.getText();
     if(text.equals(compareTo)) {
         return true;
     }
     return false;
}