@JsonIgnoreProperties({"foobar"})
public static class Foo {
    public String foo = "a";
    public String bar = "b";

    public String foobar = "c";
}

//Test code
ObjectMapper mapper = new ObjectMapper();
Foo foo = new Foo();
foo.foobar = "foobar";
foo.foo = "Foo";
String out = mapper.writeValueAsString(foo);
Foo f = mapper.readValue(out, Foo.class);