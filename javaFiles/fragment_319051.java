public static Date getWeekStart(Date date){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
    c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
    Date firstDate = c.getTime();
        return firstDate;
    }