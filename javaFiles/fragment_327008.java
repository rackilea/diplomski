Date dateBefore = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();

Instant before = dateBefore.toInstant();
Instant now = Instant.now();

Duration duration = Duration.between(before, now);
System.out.println("Days: " + duration.toDays());