List<Duration> durations = List.of(
            Duration.ofMinutes(5).plusSeconds(42), // 0:05:42
            Duration.ofSeconds(9),                 // 0:00:09
            Duration.parse("PT11M"));              // 0:11:00

    Duration sum = Duration.ZERO;
    for (Duration dur : durations) {
        sum = sum.plus(dur);
    }

    System.out.println(sum);