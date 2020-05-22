ArrayList<String> tuesdayArrayList = new ArrayList<String>();

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_M_d");

Calendar calendar = Calendar.getInstance();
int day = calendar.get(Calendar.DAY_OF_WEEK);

Date date = new Date();

Date cutoffDate;
int cutoffYear = 2013;
int cutoffMonth = Calendar.JUNE;
int cutoffDayOfMonth = 25;
cutoffDate = new GregorianCalendar(cutoffYear, cutoffMonth, cutoffDayOfMonth).getTime();

while (day != Calendar.TUESDAY) {
    calendar.add(Calendar.DATE, 1);
    day = calendar.get(Calendar.DAY_OF_WEEK);
}

int i = 0;
while (date.after(cutoffDate)) {
    calendar.add(Calendar.DATE, -7);
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    date = new GregorianCalendar(year, month, dayOfMonth).getTime();
    tuesdayArrayList.add(dateFormat.format(date));
    Log.d("myTag: ", tuesdayArrayList.get(i));
    i++;
}