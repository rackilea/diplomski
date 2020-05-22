private static String month;
private static String day;
private static String year;

public static void dateInString() {
    String dt = "01-23-2004";
    // 1.format first
    SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy",Locale.ENGLISH);
    SimpleDateFormat sdf2 = new SimpleDateFormat("MMM-dd-yyyy",Locale.ENGLISH);
    Date date = null;
    try {
        date = sdf1.parse(dt);
        String newDate= sdf2.format(date);
        System.out.println(newDate);

        // 2.split
        String[] dateParts = newDate.split("-");
        month = dateParts[0];
        day = dateParts[1];
        year = dateParts[2];
        System.out.println(month);
    } catch (ParseException e) {
        e.printStackTrace();
    }
}

public void insertBirthDateBounus() throws IOException, ParserConfigurationException, SAXException {
    comOps.selectDropDown(birthdayMonth, day);
    comOps.selectDropDown(birthdayDay, month);
    comOps.selectDropDown(birthdayYear, year);
}