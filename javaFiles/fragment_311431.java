private static Pattern datePattern = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}$");
private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");

private static LocalDate extractDate(String fullString) {
    Matcher m = datePattern.matcher(fullString);
    if (m.find()) {
        String dateString = m.group();
        return LocalDate.parse(dateString, dateFormatter);
    } else {
        throw new IllegalArgumentException("String doesn’t end with a date: " + fullString);
    }
}