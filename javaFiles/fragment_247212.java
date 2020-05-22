public static void main(String[] args) {
    int year = 2012;

    // put the month you want
    int month = Calendar.MARCH;

    Calendar cal = new GregorianCalendar(year, month, 1);
    List<String> saturdaysAndSundays = new ArrayList<String>();
    List<String> otherDays = new ArrayList<String>();
    do {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        String dayInMonth = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            saturdaysAndSundays.add(dayInMonth);
        } else {
            otherDays.add(dayInMonth);
        }
        cal.add(Calendar.DAY_OF_YEAR, 1);
    }  while (cal.get(Calendar.MONTH) == month);
    //In case you really want an array:
    String[] array = saturdaysAndSundays.toArray(new String[0]);
}