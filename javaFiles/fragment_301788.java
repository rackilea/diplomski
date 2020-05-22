String[] formats = new String[] { "dd/MM/yyyy", "dd/MM/yyyy HH:mm:ss" };
String input = "25/09/2015 10:25:31";
LocalDateTime result = null;

for (String format : formats) {
    try {
        DateTimeFormatter sdFormat = DateTimeFormat.forPattern(format);
        result = sdFormat.parseLocalDateTime(input);
        break;
    }
    catch (IllegalArgumentException e) {
    }
}
System.out.println(result);

Date resultDate = result.toDate();
System.out.println(resultDate);