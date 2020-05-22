// create a Calendar for the 1st of the required month
int year = 2010;
int month = Calendar.JANUARY;
Calendar cal = new GregorianCalendar(year, month, 1);
do {
    // get the day of the week for the current day
    int day = cal.get(Calendar.DAY_OF_WEEK);
    // check if it is a Saturday or Sunday
    if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
        // print the day - but you could add them to a list or whatever
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }
    // advance to the next day
    cal.add(Calendar.DAY_OF_YEAR, 1);
}  while (cal.get(Calendar.MONTH) == month);
// stop when we reach the start of the next month