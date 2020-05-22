class TimestampJsonSerializer implements JsonSerializer<Timestamp> {

    private final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    });

    @Override
    public JsonElement serialize(Timestamp src, Type typeOfSrc, JsonSerializationContext context) {
        String formatted = formatter.get().format(src);
        return new JsonPrimitive(formatted);
    }
}