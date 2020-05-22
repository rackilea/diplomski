private int calculateNumberOfDaysBetween(Date startDate, Date endDate) {
    if (startDate.after(endDate)) {
        throw new IllegalArgumentException("End date should be grater or equals to start date");
    }

    long startDateTime = startDate.getTime();
    long endDateTime = endDate.getTime();
    long milPerDay = 1000*60*60*24; 

    int numOfDays = (int) ((endDateTime - startDateTime) / milPerDay); // calculate vacation duration in days

    return ( numOfDays + 1); // add one day to include start date in interval
}