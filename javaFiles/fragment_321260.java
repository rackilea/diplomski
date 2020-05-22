String input = "John Doe at:2016-01-16 Notes:This is a test";

String regex = " at:(\\d{4}-\\d{2}-\\d{2}) Notes:";
Matcher m = Pattern.compile(regex).matcher(input);
if (m.find()) {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(m.group(1));
    // Use date here
} else {
    // Bad input
}