Instant doubleTime(Instant start, Instant end) {
    Long s = start.getMillis();
    Long e = end.getMillis();

    return new Instant((e - s) * 2 + s);
}