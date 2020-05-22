int startYear = 2012;
int endYear = 2013;

Calendar cal = new GregorianCalendar(startYear, Calendar.JANUARY, 1);
ArrayList<Date> dates = new ArrayList<Date>();
while(cal.get(Calendar.YEAR) < endYear){
    dates.add(cal.getTime());
    cal.add(Calendar.DATE, 1);
}