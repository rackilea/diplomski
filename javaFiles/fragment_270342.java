private Date getDateObject() {
    Calendar cld = Calendar.getInstance();
    cld.set(Calendar.YEAR, year);
    cld.set(Calendar.WEEK_OF_YEAR, week);
    cld.get(Calendar.DAY_OF_WEEK); // WARNING this line is required to make the code work. Might have something to do with an inner function called complete which gets called on get.
    cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    return cld.getTime();
}

private Date getEndDateObject() {
    Date endDateObject = getDateObject();
    long timeMilliseconds = endDateObject.getTime();
    long sixDaysMilliseconds = 60 * 60 * 24 * 6 * 1000;
    endDateObject.setTime(timeMilliseconds + sixDaysMilliseconds);
    return endDateObject;
}