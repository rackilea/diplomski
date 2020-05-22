import java.lang.StringBuilder;

class Test {
private static final int sizeOfIntInHalfBytes = 8;
private static final int numberOfBitsInAHalfByte = 4;
private static final int halfByte = 0x0F;
private static final char[] hexDigits = { 
'0', '1', '2', '3', '4', '5', '6', '7', 
'8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
};
private static String finalHexCode;

private static String decToHex(int dec) {
StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
hexBuilder.setLength(sizeOfIntInHalfBytes);
for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i)
{
  int j = dec & halfByte;
  hexBuilder.setCharAt(i, hexDigits[j]);
  dec >>= numberOfBitsInAHalfByte;
}
return hexBuilder.toString(); 
}

public static String FinalHex(int dec) {
  String ReversedHex = decToHex(dec);
  if(ReversedHex.length() != 0)
      finalHexCode = "#"+ReversedHex.substring(6, 8)+ReversedHex.substring(4, 6)+ReversedHex.substring(2, 4);
  return finalHexCode; 
}
}