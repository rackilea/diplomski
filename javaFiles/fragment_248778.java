static Map<String, DurationFieldType> durationFieldTypes = new HashMap<>();
static {
    durationFieldTypes.put("days", DurationFieldType.days());
    durationFieldTypes.put("months", DurationFieldType.months());
    ...
}