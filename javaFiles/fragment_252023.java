public Date getPreviousWorkingDay(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);

    int dayOfWeek;
    do {
        cal.add(Calendar.DAY_OF_MONTH, -1);
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
    } while (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);

    return cal.getTime();
}