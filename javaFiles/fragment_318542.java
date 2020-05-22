public static class FooReference {
    public DBRef<Foo> foo;

    @JsonView(Views.WebView.class)
    public Foo getFoo() {
        return foo.fetch();
    }
}