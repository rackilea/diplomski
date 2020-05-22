@FieldMatch.List({
        @FieldMatch(first = "name", second = "people"),
        @FieldMatch(first = "age", second = "abc")
})
public class Foo {

    private String name;
    private List<String> people;
    private int age;
    private Boolean abc; 
}