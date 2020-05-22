List<String> list = Lists.transform(fooList, new Function<Foo, String>() {
    @Override
    public String apply(Foo foo) {
        return foo.getProp();
    }
});