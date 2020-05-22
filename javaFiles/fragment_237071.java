// string with hexadecimal EBCDIC codes
String sb = "F0F8F1F0";
int countOfHexValues = sb.length() / 2;
byte[] bytes = new byte[countOfHexValues];
for(int i = 0; i < countOfHexValues; i++) {
    int hexValueIndex = i * 2;
    // take one hexadecimal string value
    String hexValue = sb.substring(hexValueIndex, hexValueIndex + 2);
    // convert it to a byte
    bytes[i] = (byte) (Integer.parseInt(hexValue, 16) & 0xFF);
}
// constructs a String by decoding bytes as EBCDIC
String string = new String(bytes, "CP1047");