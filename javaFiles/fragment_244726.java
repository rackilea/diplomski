String dateStr = "Mon Jan 32 00:00:00 IST 2015";    // 32 Jan 2015

DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
formatter.setLenient(false);
DateFormat ddMMyyyy = new SimpleDateFormat("dd.MM.yyyy");
try {
    System.out.println(ddMMyyyy.format(formatter.parse(dateStr)));
} catch (ParseException e) {
    // Your date is invalid
}