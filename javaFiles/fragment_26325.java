String hexChars = "0123456789ABCDEF";
String s = "=C3=A1 =C3=A0 =C3=A7 =C3=A3 =C3=B5 =C3=A9 =C3=9A"
        + " =C3=81 =C3=A2 =C3=A9 UHA a=C3=A7=C3=A3";
int stringIndex = 0;
int bytesIndex = 0;
byte[] bytes = new byte[s.length()];
while (stringIndex < s.length()) {
    if (s.charAt(stringIndex) == '=' 
            && hexChars.indexOf(s.charAt(stringIndex+1)) >= 0
            && hexChars.indexOf(s.charAt(stringIndex+2)) >= 0
            ) {
        int hex = hexChars.indexOf(s.charAt(stringIndex+1));
        hex <<= 4;
        hex += hexChars.indexOf(s.charAt(stringIndex+2));
        bytes[bytesIndex] = (byte) hex;
        stringIndex += 2;
    } else {
        bytes[bytesIndex] = (byte) (s.charAt(stringIndex) & 0XFF);
    }
    stringIndex++;
    bytesIndex++;
}
System.out.println("bytes = " + new String(bytes, 0, bytesIndex, 
        StandardCharsets.UTF_8));