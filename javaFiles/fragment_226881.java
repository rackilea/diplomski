TreeSet<LocalTime> times = new TreeSet<> ();
times.add(LocalTime.parse("05:40"));
times.add(LocalTime.parse("06:40"));
times.add(LocalTime.parse("08:30"));
//...

LocalTime ceiling = times.ceiling(LocalTime.now());
if (ceiling != null) //do something with it