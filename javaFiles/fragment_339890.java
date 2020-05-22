public final class Streams {
    public static LongStream toLongStream(Stream<Long> stream) {
        return stream.mapToLong(Long::longValue);
    }

    public static Stream<Long> toStreamLong(LongStream stream) {
        return stream.boxed();
    }

    private Streams() {}
}