String value = "This is a simple string";
for (int index = 0; index < value.length(); index++) {

    String whatIs = "Unknown";
    if (Character.isUpperCase(value.charAt(index))) {
        whatIs = "Upper case";
    } else if (Character.isLowerCase(value.charAt(index))) {
        whatIs = "Lower case";
    } else if (Character.isSpaceChar(value.charAt(index))) {
        whatIs = "Space";
    } else if (Character.isDigit(value.charAt(index))) {
        whatIs = "Digit";
    }

    System.out.println("Character @ " + index + " (" + value.charAt(index) + ") is a " + whatIs + " character");

}