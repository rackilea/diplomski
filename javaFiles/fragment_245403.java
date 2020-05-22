// input
String[] periods = { "03:20:45", "00:40:11", "23:00:48" };

// initialization
Duration.Formatter<ClockUnit> timeFormat = 
    Duration.Formatter.ofPattern(ClockUnit.class, "hh:mm:ss");
Duration<ClockUnit> dur = Duration.ofZero();

// calculate the sum
for (String entry : periods) { 
    dur = dur.plus(timeFormat.parse(entry));
}

dur = dur.with(Duration.STD_CLOCK_PERIOD); // normalization
System.out.println(timeFormat.format(dur)); // 27:01:44