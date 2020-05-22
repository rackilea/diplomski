import static java.util.Calendar.MINUTE;

...

final Time t = ... your Time instance ...;
final Calendar c = Calendar.getInstance();
c.setTime(t);
c.add(MINUTE, 10);
t.setTime(c.getTimeInMillis());