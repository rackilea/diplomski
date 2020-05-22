return tempString += "" 
    + inString.charAt(inString.length() - 1)
    + inString.charAt(1)
    + revEven2(inString.substring(2, inString.length() - 2))
    + inString.charAt(inString.length() - 2)
    + inString.charAt(0);
}