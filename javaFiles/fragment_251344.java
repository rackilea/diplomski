private List<String> foo;

public List<String> getFoo() {
    if (this.foo == null) {
        this.foo == new ArrayList<>();
    }
    return this.foo;
}