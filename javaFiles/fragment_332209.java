class ClassWithAMap {

    private Map<Range<Instant>, String> map;

    @JsonCreator
    public ClassWithAMap(
            @JsonProperty("map")
            @JsonDeserialize(keyUsing = RangeDeserializer.class)
            Map<Range<Instant>, String> map) {
        this.map = map;
    }
}