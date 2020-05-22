char[] charArray = str.toCharArray();
for (int i = 0; i < charArray.length; i++) {
    char c = charArray[i];
    if ((int) c >= 65 && (int) c <= 90) {
        arrASCII.append(((int) c - 64)* (i+1));
    } else if ((int) c >= 97 && (int) c <= 122) {
        arrASCII.append(((int) c - 96)* (i+1));
    } else if ((int) c >= 48 && (int) c <= 57) {
        arrASCII.append(((int) c - 48)* (i+1));
    } else arrASCII.append(1);
}
barcodeResult.setText(gpnText.getText() + "~" + wpnText.getText() +
    "~" + wsnText.getText() + "~" + arrASCII.toString());