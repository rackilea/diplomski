String timestamp = "2019-08-17T09:51:41.7754321+00:00";
    OffsetDateTime date = OffsetDateTime.parse(timestamp);
    Instant asInstant = date.toInstant();
    long epoch = TimeUnit.SECONDS.toMicros(asInstant.getEpochSecond())
            + asInstant.get(ChronoField.MICRO_OF_SECOND);
    System.out.println(epoch);