class BaseDTO {
    private AccumulatorDTO sms;
    private AccumulatorDTO voice;
    private AccumulatorDTO mms;

    @JsonCreator
    public BaseDTO(@JsonProperty("accumulators") final AccumulatorDTO[] accumulators) {
        for (AccumulatorDTO accumulator : accumulators) {
            String fieldName = accumulator.getName().toLowerCase();
            try {
                Field field = getClass().getDeclaredField(fieldName);
                field.set(this, accumulator);
            } catch (NoSuchFieldException | IllegalAccessException ignored) {
            }
        }
    }
}