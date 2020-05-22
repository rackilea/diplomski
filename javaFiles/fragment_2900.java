Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

    calendar1.clear();
    calendar1.set(1997, 9, 3);
    calendar2.clear();
    calendar2.set(1997, 9, 1);

    long milliseconds1 = calendar1.getTimeInMillis();
    long milliseconds2 = calendar2.getTimeInMillis();