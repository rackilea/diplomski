private static boolean isLongEnough(String pwd) {
    return pwd.length() >= 6;
}

private static boolean hasNoSpaces(String pwd) {
    return !pwd.contains(" ");
}