public static boolean isValidElement(String token) {
    if (token == null || token.isEmpty() || token.charAt(0) == '+')
        return false;
    try {
        int num = Integer.parseInt(token);
        return (num >= 0 && num <= 255);
    } catch (@SuppressWarnings("unused") NumberFormatException e) {
        return false;
    }
}