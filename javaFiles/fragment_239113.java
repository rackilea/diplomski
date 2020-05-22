private int calculateNumberOfDaysExcludeWeekends(Date startDate, Date endDate) {
    if (startDate.after(endDate)) {
        throw new IllegalArgumentException("End date should be grater or equals to start date");
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);

    int numOfDays = 0;
    while(!calendar.getTime().after(endDate)) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if ( (dayOfWeek>1) && (dayOfWeek<7) ) {
            numOfDays++;
        }
        calendar.add(Calendar.DAY_OF_MONTH, 1);
    }

    return numOfDays;
}