private static boolean isValidPassword(char[] password) {
    boolean hasLetter = false, hasDigit = false, hasSpecial = false;
    for (char ch : password)
        if (Character.isLetter(ch))
            hasLetter = true;
        else if (Character.isDigit(ch))
            hasDigit = true;
        else if ("@#$".indexOf(ch) != -1)
            hasSpecial = true;
    return (hasLetter && hasDigit && hasSpecial);
}