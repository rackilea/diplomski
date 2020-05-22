public static String alphaNumeric(String input) {
    return alphaHelper(input, "");
}

private static String alphaHelper(String in, String current) {
    String result = null;

    if (check(current)) {
        result = current;
    } else if (Character.isLetter(in.charAt(0))) {
        result = alphaHelper(in.substring(1),current+in.substring(0,1).toLowerCase());
        if (result == null) result = alphaHelper(in.substring(1),current+in.substring(0,1).toUpperCase());
    } else if (Character.isDigit(in.charAt(0))) {
        result = alphaHelper(in.substring(1),current+in.substring(0,1));
    }

    return result;
}