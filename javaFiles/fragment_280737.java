public Date[] calcDateRangeWeek(Calendar c, int day) {
    Date[] dr = new Date[2];
    // setMin
    c.set(day, Calendar.MONDAY);
    dr[0] = c.getTime();
    // setMax
    c.set(day, Calendar.SUNDAY);
    dr[1] = c.getTime();
    return dr;
}