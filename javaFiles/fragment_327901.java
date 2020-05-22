//create calendar with locale
    Calendar cal = Calendar.getInstance(Locale.GERMANY);

    //weeks of year you want
    int fromWeek = 1;
    int toWeek = 10;

    //date format
    DateFormat df = new SimpleDateFormat("EEE yyyy/MM/dd");

    //print date range
    for (int i = fromWeek; i <= toWeek; i++) {
        //set calendar to specified week of year
        cal.set(Calendar.WEEK_OF_YEAR, i);
        //set calendar to first day of the week
        //(might be different in different locales)
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        //print date range of this week
        System.out.print(
            "Week no. " + i + " from " +
            df.format(cal.getTime()) + " to "
        );
        cal.add(Calendar.DAY_OF_YEAR, 6);
        System.out.println(df.format(cal.getTime()));
    }