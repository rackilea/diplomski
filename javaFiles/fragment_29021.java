public static String compress (String original){
    String str = "";
    int count = 0;
    char currentChar = original.charAt(0);
    for(int i=0; i<original.length(); i++){
        if (currentChar == original.charAt(i)) { // count it if this not a new character
            currentChar = original.charAt(i);
            count++;
        } else { // if we have encountered a new character
            if (count > 2) { // and we have already counted 2 or more of the previous char
                if (Character.isDigit(currentChar)) {
                    str += "#" + count + "#" + currentChar;
                } else {
                    str += "#" + count + currentChar;
                }
            } else if (count == 2) { // if we have only counted two of the previous char
                str += currentChar;
                str += currentChar;
            } else if (count == 1) { // if we have only counted one of the previous char
                str += currentChar;
            }
            currentChar = original.charAt(i);
            count = 1;
        }
    }
    // treat the end of the string as a new char
    if (count > 2) {
        if (Character.isDigit(currentChar)) {
            str += "#" + count + "#" + currentChar;
        } else {
            str += "#" + count + currentChar;
        }
    } else if (count == 2) {
        str += currentChar;
        str += currentChar;
    } else if (count == 1) {
        str += currentChar;
    }
    return str;
}