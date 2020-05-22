String dateInString = "2015-07-16 17:07:21"
SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-ss HH:mm:ss");
SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
try {
    Date date = inputFormat.parse(dateInString);
    System.out.println("Date ->" + outputFormat.format(date));
} catch (ParseException e) {
    e.printStackTrace();
}