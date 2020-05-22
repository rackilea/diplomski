public static void main(String[] args) throws Exception {

    // Convert your representation of a char into a String object: 
    String utf8char = "e2 80 99";
    String[] strNumbers = utf8char.split(" ");
    byte[] rawChars = new byte[strNumbers.length];
    int index = 0;
    for(String strNumber: strNumbers) {
        rawChars[index++] = (byte)(int)Integer.valueOf(strNumber, 16);
    }
    String utf16Char = new String(rawChars, Charset.forName("UTF-8"));

    // get the resulting characters (Java Strings are "encoded" in UTF16)
    int codePoint = utf16Char.charAt(0);
    if(Character.isSurrogate(utf16Char.charAt(0))) {
        codePoint = Character.toCodePoint(utf16Char.charAt(0), utf16Char.charAt(1));
    }
    System.out.println("code point: " + Integer.toHexString(codePoint));
}