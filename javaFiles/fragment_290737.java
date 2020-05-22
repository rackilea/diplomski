class Foo {

    private String name;
    private int age;

    @JsonIgnore
    private Map<String, Object> extra;

    @JsonAnyGetter
    public Map<String, Object> getExtra() {
       return extra;
    }
}