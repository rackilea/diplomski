//create calendar with locale
    Calendar cal = Calendar.getInstance(Locale.GERMANY);

    //week of year you want
    int weekOfYear = 4;

    //set calendar to specified week of year
    cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);

    //set calendar to first day of the week
    //(might be different in different locales)
    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

    //print dates of this week
    DateFormat df = new SimpleDateFormat("EEE yyyy/MM/dd");
    for (int i = 0; i < 7; i++) {
        System.out.println(df.format(cal.getTime()));
        cal.add(Calendar.DATE, 1);
    }