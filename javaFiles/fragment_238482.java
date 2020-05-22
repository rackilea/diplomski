class DateJsonSerializer implements JsonSerializer<Date> {

    private final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        String formatted = formatter.get().format(src);

        return new JsonPrimitive(formatted);
    }
}