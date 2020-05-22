String dateString1 = "2011-01-01";
String dateString2 = "2012-01-01";

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

List<String> dates = new ArrayList<String>();

Date startDate = dateFormat.parse(dateString1);
Date endDate = dateFormat.parse(dateString2);

GregorianCalendar calendar = new GregorianCalendar();
calendar.setTime(startDate);
while (calendar.getTime().before(endDate)) {
    dates.add(dateFormat.format(calendar.getTime()));
    calendar.add(Calendar.DAY_OF_MONTH, 1);
}