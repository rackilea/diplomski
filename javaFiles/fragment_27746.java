String name = jTextField.getText();
char[] charArray = name.toCharArray();
for (char c : charArray) {
    if (!(c <= 0x05ea && c >= 0x05d0)) {
        break;
        //valid
    }
}