public static String convertString(String conversionString) {

  String letters =        "abcdefghijklmnopqrstuvwxyz";
  String encodedLetters = "qwertyuiopasdfghjklzxcvbnm";

  conversionString = conversionString.toLowerCase();

  char[] letterChar = letters.toCharArray();
  char[] encChar = encodedLetters.toCharArray();

  char[] stringChar = conversionString.toCharArray();

  StringBuilder sb = new StringBuilder();

  for (int i = 0; i < stringChar.length; i++) {
    int j = letters.indexOf(stringChar[i]); 
    sb.append(conversionString.substring(i, i + 1).replace(letterChar[j], encChar[j]));   
  }

  return sb.toString();
}