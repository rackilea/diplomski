/*
    Code which defines a scanner class and FileInputStream
*/
String lineInFile = scannerName.nextLine();
int[] convertMeToHex = new int[lineInFile.length()];

for (int i = 0; i < convertMeToHex.length; i++)
    convertMeToHex[i] = (int) lineInFile.charAt(i);

String[] hex = new String[convertMeToHex.length];

for (int i = 0; i < convertMeToHex.length; i++)
    hex[i] = Integer.toHexString(convertMeToHex[i]));