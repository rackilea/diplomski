@DatabaseTable
public class Foo {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField(foreign = true)
    private FooResult result;

    // getters and setters
    ...
}