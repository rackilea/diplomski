GregorianCalendar calendar = new GregorianCalendar();
DateFormat df = new SimpleDateFormat("EEEE");
for (int i = 0; i < 7; i++) {
    calendar.add(Calendar.DATE, 1);
    System.out.println(df.format(calendar.getTime()));
}