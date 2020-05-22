Calendar cal = Calendar.getInstance();
// init to date picked by user
cal.setTime(myDate);
while([your stop condition here]) {
    // go to same day next week
    cal.add(Calendar.WEEK_OF_YEAR, 1);
    Date next = cal.getTime();
    // .. do something with the date
}