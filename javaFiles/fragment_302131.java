GregorianCalendar calendar = new GregorianCalendar();
DateFormat df = new SimpleDateFormat("MMMM");
for (int i = 0; i < 12; i++) {
    calendar.add(Calendar.MONTH, 1);
    System.out.println(df.format(calendar.getTime()));
}