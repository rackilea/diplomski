class Foo {
    private Map<String, Object> things;             // <== Changed
    private Map<String, Object> moreThings;         // <== Changed

    protected Map<String, Object> getThings() {     // <== Changed
        return this.things;
    }

    protected Map<String, Object> getMoreThings() { // <== Changed
        return this.moreThings;
    }

    public Foo() {
        this.things = new HashMap<String, Object>();
        this.moreThings = new HashMap<String, Object>();
    }

    // ...more...
}