int selectedYear = 2013;
    int selectedDay = 20;
    int selectedMonth = 11;

    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, selectedYear);
    cal.set(Calendar.DAY_OF_MONTH, selectedDay);
    cal.set(Calendar.MONTH, selectedMonth);
    String format = new SimpleDateFormat("E, MMM d, yyyy").format(cal.getTime());