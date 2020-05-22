Calendar now = Calendar.getInstance();
    int month = now.get(Calendar.MONTH);
    int day = now.get(Calendar.DAY_OF_MONTH);
    int year = now.get(Calendar.YEAR);

    MonthLong.setSelectedIndex(month);
    DayLong.setSelectedItem(Integer.toString(day));
    YearLong.setSelectedItem(Integer.toString(year));