DateFormat df = new SimpleDateFormat("HH:mm");
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
int startDate = cal.get(Calendar.DATE);
while (cal.get(Calendar.DATE) == startDate) {
    System.out.println(df.format(cal.getTime()));
    cal.add(Calendar.MINUTE, 30);
}