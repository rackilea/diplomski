// Once the two streams are connected, the Watermark of the KeyedBroadcastProcessFunction operator
// will be the minimum of the Watermarks of the two connected streams. Our config stream has a default
// Watermark at Long.MIN_VALUE, and this will hold back the event time clock of the
// KeyedBroadcastProcessFunction, unless we do something about it.

public static class ConfigStreamAssigner implements AssignerWithPeriodicWatermarks<String> {
    @Nullable
    @Override
    public Watermark getCurrentWatermark() {
        return Watermark.MAX_WATERMARK;
    }

    @Override
    public long extractTimestamp(String element, long previousElementTimestamp) {
        return 0;
    }
}