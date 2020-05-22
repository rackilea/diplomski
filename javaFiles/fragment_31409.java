public class MyClass {
    private Optional<MyCustomObject> object;

    public MyClass(Optional<MyCustomObject> object) {
        this.object = object;
    }

    // Ignore the "normal" serialization
    @JsonIgnore
    public Optional<MyCustomObject> getObject() {
        return this.object;
    }

    public void setObject(Optional<MyCustomObject> object) {
        this.object = object;
    }

    // This handles the serialization
    @JsonProperty("object")
    private MyCustomObject getObjectAndYesThisIsAPrivateMethod() {
        return getObject().orElse(null);
    }
}