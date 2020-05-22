// TODO: Which time zone are you interested in?
Calendar calendar = Calendar.getInstance();
DateFormat format = new SimpleDateFormat("yyyyMM");
List<String> dates = new ArrayList<>();
for (int i = 0; i < 6; i++) {
    dates.add(format.format(calendar.getTime()));
    calendar.add(Calendar.MONTH, 1);
}