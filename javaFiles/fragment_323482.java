LocalTime now = LocalTime.now();
LocalTime previous = LocalTime.of(0, 0, 0, 0);
Duration duration = Duration.between(previous, now);

System.out.println(now);
System.out.println(previous);
System.out.println(duration);