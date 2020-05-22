import static java.util.Calendar.*;

final Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(yourValue);
cal.set(HOUR_OF_DAY, 12);
cal.set(MINUTE, 0);
cal.set(SECOND, 0);
cal.set(MILLISECOND, 0);
// cal.getTimeInMillis() contains the wanted day at 12pm
cal.add(DAY_OF_YEAR, 1);
// cal.getTimeInMillis() now contains the wanted day plus one at 12pm