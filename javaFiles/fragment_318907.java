Instant instant = Instant.parse("2018-08-28T10:23:25.617Z"); // start time in UTC
Instant now = Instant.now();  // end time in UTC

Duration duration = Duration.between(instant, now); // the Duration

System.out.println(duration.toSeconds()); // duration in seconds