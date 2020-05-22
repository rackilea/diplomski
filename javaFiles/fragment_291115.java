SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
String currentDateInput = "23 01 1997";
String actionDateInput = "27 04 1997";

try {
    Date currentDate = myFormat.parse(currentDateInput);
    Date actionDate = myFormat.parse(actionDateInput);
    long diff = actionDate.getTime() - currentDate.getTime();
    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
} catch (ParseException e) {
    e.printStackTrace();
}