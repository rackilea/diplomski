Calendar cal = GregorianCalendar.getInstance();
    cal.setTime(date);
    // cal.set(Calendar.HOUR, 0);   // As jarnbjo pointed out this isn't enough
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);