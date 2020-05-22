if (Character.isLetter(x.charAt(i - 1))) { //added getting character from input String
    char ch = x.charAt(i);
    completedConversion = completedConversion + ch;
} else {
    char ch = x.charAt(i);
    ch = Character.toUpperCase(ch);
    completedConversion = completedConversion + ch;
}