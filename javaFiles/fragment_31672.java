class MyUUIDClass {
    public int knownField;

    Map<String, UUID> unknownFields = new HashMap<>();

    // Capture all other fields that Jackson do not match other members
    @JsonAnyGetter
    public Map<String, UUID> otherFields() {
        return unknownFields;
    }

    @JsonAnySetter
    public void setOtherField(String name, UUID value) {
        unknownFields.put(name, value);
    }
}