class A {
    @JsonProperty("id")
    Integer id;

    @JsonProperty("b")
    @JsonIgnoreProperties({"c"})
    B b;
    // constructors, getters, etc.
}