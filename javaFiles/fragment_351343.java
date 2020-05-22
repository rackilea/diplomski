public static String[] split(String input) {
    if (input.charAt(0) == '"') {
        return input.substring(1).split("\" ");
    } else {
        return input.substring(0, input.length() - 1).split(" \"");
    }
}