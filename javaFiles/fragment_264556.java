public static final String inputFormat = "HH:mm";

private Date date;
private Date dateCompareOne;
private Date dateCompareTwo;

private String compareStringOne = "9:45";
private String compareStringTwo = "1:45";

SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.US);

private void compareDates(){
    Calendar now = Calendar.getInstance();

    int hour = now.get(Calendar.HOUR);
    int minute = now.get(Calendar.MINUTE);

    date = parseDate(hour + ":" + minute);
    dateCompareOne = parseDate(compareStringOne);
    dateCompareTwo = parseDate(compareStringTwo);

    if ( dateCompareOne.before( date ) && dateCompareTwo.after(date)) {
        //yada yada
    }
}

private Date parseDate(String date) {

    try {
        return inputParser.parse(date);
    } catch (java.text.ParseException e) {
        return new Date(0);
    }
}