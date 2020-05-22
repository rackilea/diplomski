@JsonSerialize(using = FooSerializer.class)
public class Foo {
    private String bar;

    public String bar() {
        return bar;
    }
}