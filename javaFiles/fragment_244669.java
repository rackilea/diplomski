public static boolean isLetter(char c) {
    return (c > 64 && c < 91) || (c > 96 && c < 123);
}

//Not necessary but included anyways
public static boolean isUpperCase(char c) {
    return c > 64 && c < 91;
}

public static boolean isSpace(char c) {
    //Accounts for spaces and other "space-like" characters
    return c == 32 || c == 12 || c == 13 || c == 14;
}