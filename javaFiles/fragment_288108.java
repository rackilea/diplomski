public Pair<String,String> getWeekRange(int year, int week_no) {

    Calendar cal = Calendar.getInstance();

    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    cal.set(Calendar.YEAR, year);
    cal.set(Calendar.WEEK_OF_YEAR, week_no);
    Date monday = cal.getTime();

    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    cal.set(Calendar.YEAR, year);
    cal.set(Calendar.WEEK_OF_YEAR, week_no);
    Date sunday = cal.getTime();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    return new Pair<String,String>(sdf.format(monday), sdf.format(sunday));
}