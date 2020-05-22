public static String flipCaseCharacters(String inputString, String charactersToFlip) {
    StringBuilder newString = new StringBuilder();
    for (char inChar : inputString.toCharArray()) {
        for (char ctFlip : charactersToFlip.toCharArray()) {
            if (Character.toUpperCase(inChar) == Character.toUpperCase(ctFlip)) {
                inChar = Character.isUpperCase(inChar) ? 
                         Character.toLowerCase(inChar) : 
                         Character.toUpperCase(inChar);
                break;
            }
        }
        newString.append(inChar);
    }
    return newString.toString();
}