public static List<Date> convertToDates(List<String> dateStrings) throws ParseException {
    List<Date> dates = new ArrayList<>();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    for (String dateString : dateStrings) {
        dates.add(df.parse(dateString));
    }

    return dates;
}