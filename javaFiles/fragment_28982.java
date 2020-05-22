Calendar c = Calendar.getInstance();
c.setTime(someDate);
int hour = c.get(Calendar.HOUR_OF_DAY);
if (hour < 12) {
    // 0 <= hour < 12
}