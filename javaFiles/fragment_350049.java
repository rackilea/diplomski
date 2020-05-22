if (Character.isLetter(i - 1)) {
    char ch = x.charAt(i);
    completedConversion = completedConversion + ch;
} else {
    char ch = x.charAt(i);
    ch = Character.toUpperCase(ch);
    completedConversion = completedConversion + ch;
}