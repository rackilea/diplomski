public static boolean isPasswordValid(String password)
{
    if (password.length() < 10) {
        return false;
    }

    int lc = 0, uc = 0, digit = 0;

    for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);

        if (Character.isLowerCase(c)) {
            lc++;
        } else if (Character.isUpperCase(c)) {
            uc++;
        } else if (Character.isDigit(c)) {
            digit++;
        }
    }

    return lc > 0 && uc > 0 && digit > 0;
}