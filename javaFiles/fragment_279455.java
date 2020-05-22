class Foo {
    private HashMap<String, Object> things;
    private HashMap<String, Object> moreThings;

    protected HashMap<String, Object> getThings() {
        return this.things;
    }

    protected HashMap<String, Object> getMoreThings() {
        return this.moreThings;
    }

    public Foo() {
        this.things = new HashMap<String, Object>();
        this.moreThings = new HashMap<String, Object>();
    }

    // ...more...
}