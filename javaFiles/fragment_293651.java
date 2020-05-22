public static Date getFirstDateOfMonth(Date aDate) {
    Calendar c = Calendar.getInstance();
    c.setTime(aDate);
    c.set(Calendar.DATE, 1);
    return c.getTime();
}