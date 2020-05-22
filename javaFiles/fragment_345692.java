public static Date getNextTime(Date base, int hourOfDay) {
    Calendar then = Calendar.getInstance();
    then.setTime(base);
    then.set(Calendar.HOUR_OF_DAY, hourOfDay);
    then.set(Calendar.MINUTE, 0);
    then.set(Calendar.SECOND, 0);
    then.set(Calendar.MILLISECOND, 0);
    if (then.getTime().before(base)) {
        then.add(Calendar.DAY_OF_YEAR, 1);
    }
    return then.getTime();
}

Date nextOccurrenceOf3am = getNextTime(myDate, 3);