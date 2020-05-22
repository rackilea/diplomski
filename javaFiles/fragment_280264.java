final Calendar cal = Calendar.getInstance();
if (args.length != 0) {

    try {
        setCalendarDate(cal, args[0]);
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
}
final int weekDay = cal.get(Calendar.DAY_OF_WEEK);
System.out.printf("%sday\n", weekDays[weekDay - 1]);