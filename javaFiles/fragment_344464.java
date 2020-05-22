// initialization of parser and duration
Duration.Formatter<ClockUnit> parser =
    Duration.Formatter.ofPattern(ClockUnit.class, "#h:#m[:#s]");
Duration<ClockUnit> d = Duration.ofZero();

// parse the durations inside your loop and sum up
d = d.plus(parser.parse("0:0")); // PT0S
d = d.plus(parser.parse("0:00:00")); // PT0S

// here the final evaluation of the result
d = d.with(Duration.STD_CLOCK_PERIOD);
Duration.Formatter<ClockUnit> printer =
        Duration.Formatter.ofPattern(ClockUnit.class, "##hh:mm:ss");
System.out.println(printer.format(d)); // 00:00:00