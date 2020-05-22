public static boolean isValidElement(String token) {
    if (token == null || token.isEmpty())
        return false;
    // skip leading zeroes
    int i = 0;
    while (i < token.length() && token.charAt(i) == '0')
        i++;
    // validate remaining
    char ch;
    switch (token.length() - i) {
        case 0:
            return true; // Allow "0"
        case 1:
            ch = token.charAt(i);
            return (ch >= '1' && ch <= '9'); // Allow "1" to "9"
        case 2:
            ch = token.charAt(i);
            if (ch >= '1' && ch <= '9') {
                ch = token.charAt(i + 1);
                return (ch >= '0' && ch <= '9'); // Allow "10" to "99"
            }
            return false;
        case 3:
            ch = token.charAt(i);
            if (ch == '1') {
                ch = token.charAt(i + 1);
                if (ch >= '0' && ch <= '9') {
                    ch = token.charAt(i + 2);
                    return (ch >= '0' && ch <= '9'); // Allow "100" to "199"
                }
            } else if (ch == '2') {
                ch = token.charAt(i + 1);
                if (ch >= '0' && ch <= '4') {
                    ch = token.charAt(i + 2);
                    return (ch >= '0' && ch <= '9'); // Allow "200" to "249"
                } else if (ch == '5') {
                    ch = token.charAt(i + 2);
                    return (ch >= '0' && ch <= '5'); // Allow "250" to "255"
                }
            }
            return false;
        default:
            return false;
    }
}