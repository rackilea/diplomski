String your_string = ""; // Variable to copy the new string into
String userString = "this_string"; // String to do replacement on
int lastCharacter = userString.length() - 1; // Length of inputted string
String replace = "g"; // Thing to replace
String replaceWith = "d"; // Thing to replace with
int count = 0; // Index of character in string
while(lastCharacter >= 0) {
    char nextCharacter = userString.charAt(count);
    String nextCharacterString = nextCharacter + "";
    if (nextCharacterString.equals(replace)) {
        nextCharacterString = replaceWith; // I changed += to = because we want to replace, not add
    }
    System.out.print(nextCharacterString);
    your_string = your_string + nextCharacterString; // This is where we add the correct character to the string
    lastCharacter--;
    count++;
}