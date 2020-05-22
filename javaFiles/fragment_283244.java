List<Date> dates = new ArrayList<Date>(25);
Calendar cal = Calendar.getInstance();
cal.setTime(fromDate);
while (cal.getTime().before(toDate)) {
    cal.add(Calendar.DATE, 1);
    dates.add(cal.getTime());
}