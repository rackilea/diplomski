String[] stringDates = {
    "01-MAR-2013",
    "02-MAR-2013",
    "03-MAR-2013",
    "04-MAR-2013",
    "05-MAR-2013",
    "06-MAR-2013",
    "07-MAR-2013",
    "08-MAR-2013",
    "09-MAR-2013",
    "10-MAR-2013"};

SimpleDateFormat inFormat = new SimpleDateFormat("dd-MMM-yyyy");
Date[] dates = new Date[stringDates.length];
for (int i = 0; i < stringDates.length; i++) {
    try {
        dates[i] = inFormat.parse(stringDates[i]);
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
}

SimpleDateFormat outFormat = new SimpleDateFormat("dd-MM-yyyy");
for (Date date : dates) {
    System.out.println("[" + date + "] - [" + outFormat.format(date) + "]");
}