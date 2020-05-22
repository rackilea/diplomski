public static void main(String[] args) throws ParseException {

    String[] dateArray = new String[10]; // this can be a list as well (containing the date strings or null

    for (String dateStr : dateArray) {
        if (dateStr != null) {
            LocalDateTime parse = LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
            String format = parse.format(DateTimeFormatter.ofPattern("dd MMM yyyy hha"));
            System.out.println(format);
        }
    }
}