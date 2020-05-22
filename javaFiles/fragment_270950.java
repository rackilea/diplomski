public static Integer tryParseInt(String text) {
    if (text != null && !text.isEmpty()) {
        if (text.trim().matches("[0-9]+")) {
            return Integer.valueOf(text.trim());
        }
    }
    return null;
}