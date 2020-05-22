Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 2015);
    cal.set(Calendar.MONTH, Calendar.DECEMBER);
    cal.set(Calendar.DAY_OF_MONTH, 31);

    int ordinalDay = cal.get(Calendar.DAY_OF_YEAR);
    int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
    int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
    System.out.println(numberOfWeeks);