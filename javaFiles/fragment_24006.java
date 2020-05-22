try {
    String dateText = "20130227";
    SimpleDateFormat toDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = toDateFormat.parse(dateText);

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);

    int dow = cal.get(Calendar.DAY_OF_WEEK);
    switch (dow) {
        case Calendar.THURSDAY:
        case Calendar.FRIDAY:
        case Calendar.SATURDAY:
        case Calendar.SUNDAY:
            while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.THURSDAY) {
                cal.add(Calendar.DATE, -1);
            }
            break;
        case Calendar.MONDAY:
        case Calendar.TUESDAY:
        case Calendar.WEDNESDAY:
            while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                cal.add(Calendar.DATE, -1);
            }
            break;
    }

    System.out.println(date);
    System.out.println(cal.getTime());

} catch (ParseException exp) {
    exp.printStackTrace();
}