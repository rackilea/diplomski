public void printDate(int weekOfMonth, int dayOFWeek) {

    Calendar calendar = Calendar.getInstance(Locale.US);

    calendar.set(Calendar.WEEK_OF_MONTH, weekOfMonth);
    calendar.set(Calendar.DAY_OF_WEEK, dayOFWeek);

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println(df.format(calendar.getTime()));
}