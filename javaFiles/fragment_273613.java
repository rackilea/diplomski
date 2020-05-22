public static boolean compareFormat(String inputValue, DateTimeFormatter format) {
    try {
        format.parse(inputValue);
        // parsing succeeded; so the format seems to match
        return true;
    } catch (DateTimeParseException dtpe) {
        return false;
    }
}