class FooDto {
    String fooProperty;
    String barProperty;

    public FooDto(String fooProperty, String barProperty) {
        this.fooProperty = fooProperty;
        this.barProperty = barProperty;
    }

    public static Stream<FooDto> from(Foo foo) {
        return foo.bars.stream().map(bar -> new FooDto(foo.fooProperty, bar.barProperty));
    }
}