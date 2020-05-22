public static final long EPOCH_OFFSET = 62135596800L; // -Instant.parse("0001-01-01T00:00:00Z").getEpochSecond()

private static long getTicks(Instant instant) {
    long seconds = Math.addExact(instant.getEpochSecond(), EPOCH_OFFSET);
    long ticks = Math.multiplyExact(seconds, 10_000_000L);
    return Math.addExact(ticks, instant.getNano() / 100);
}

public static void main(String[] args) {
    Instant startTime = Instant.parse("2016-08-23T13:28:00Z");
    String s = String.format("%19d", DATETIME_MAXVALUE_TICKS - getTicks(startTime));
    System.out.println(s);
}