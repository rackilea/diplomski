if (!Character.isWhitespace(x.charAt(i - 1))) {
    //if previous char is not a whitespace don't change case
    char ch = x.charAt(i);
    completedConversion = completedConversion + ch;
} else {
    //if previous char is a whitespace change to uppercase
    char ch = x.charAt(i);
    ch = Character.toUpperCase(ch);
    completedConversion = completedConversion + ch;
}