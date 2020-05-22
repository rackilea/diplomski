private static final String[] bankHolidays = {"25/03/2016", "28/03/16", "02/05/2016", "20/05/2016"};
private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
private static Set<Calendar> holidayDates;

public static void main(String[] args) throws ParseException {
    if (holidayDates == null) {
        holidayDates = new HashSet<Calendar>();
        for (int i = 0; i < bankHolidays.length; i++) {
            Calendar c = Calendar.getInstance();
            Date date = sdf.parse(bankHolidays[i]);
            c.setTime(date);
            holidayDates.add(c);
        }
    }
}