Instant now = Instant.now();
    Duration diff = Duration.between(
            LocalTime.MIN,
            LocalTime.parse("02:00:00")
    );
    Instant res = now.plus(diff);

    System.out.println("res = " + Timestamp.from(res));