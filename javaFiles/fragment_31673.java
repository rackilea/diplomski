class MyClass {
    public int knownField;

    Map<String, String> unknownFields = new HashMap<>();

    // Capture all other fields that Jackson do not match other members
    @JsonAnyGetter
    public Map<String, String> otherFields() {
        return unknownFields;
    }

    @JsonAnySetter
    public void setOtherField(String name, String value) {
        unknownFields.put(name, value);
    }
}