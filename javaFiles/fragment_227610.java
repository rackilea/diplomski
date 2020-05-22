private static String getFormat(String time) {
    String firstRegEx = "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z$";
    String secondRegEx = "^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s\\w{3}$";

    if (time.matches(firstRegEx)) {
        return firstRegEx;
    } else if (time.toLowerCase().matches(secondRegEx)) {
        return secondRegEx;
    }
    return null;
}