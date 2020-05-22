private static Date getFirstDayOfQuarter(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)/3 * 3);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    return cal.getTime();
}

private static Date getLastDayOfQuarter(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)/3 * 3 + 2);
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    return cal.getTime();
}