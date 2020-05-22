class Impl implements Interface {
    //...

    @Override
    @JsonSerialize
    @JsonValue(false) //...disables inherited annotation
    public String fieldA() {
        return fieldA;
    }

    // ...
}