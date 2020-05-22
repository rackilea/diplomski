public TimeSpan addEstimatedToTime(Date time) {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    //first we get the days
    long workingDays =  this.getEstimatedDuration() / 540;
    //then the remaining hours and minutes
    long remainderDays = this.getEstimatedDuration() % 540;
    //then we calculate the hours
    long workingHours = remainderDays/60;
    //and the remaining are the minutes
    long workingMinutes = remainderDays % 60;

    //convert to calendar to add the estimated time to the given time
    Calendar cal = Calendar.getInstance();
    cal.setTime(time);
    cal.add(Calendar.DATE,(int) workingDays);
    cal.add(Calendar.HOUR , (int) workingHours);
    cal.add(Calendar.MINUTE, (int) workingMinutes);

    //format back to date
    String endTime = format.format(cal.getTime());
    Date plannedEndTime = format.parse(endTime);

    return new TimeSpan(time,plannedEndTime);
}