List<String> allDates = new ArrayList<>();
String maxDate = "Jan-2016";
SimpleDateFormat monthDate = new SimpleDateFormat("MMM-yyyy");
Calendar cal = Calendar.getInstance();
cal.setTime(monthDate.parse(maxDate));
for (int i = 1; i <= 12; i++) {
    String month_name1 = monthDate.format(cal.getTime());
    allDates.add(month_name1);
    cal.add(Calendar.MONTH, -1);
}
System.out.println(allDates);