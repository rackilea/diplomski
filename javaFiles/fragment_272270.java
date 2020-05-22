@DatabaseTable
public class FooResult {
    @DatabaseField(id = true)
    private int id;
    @ForeignCollectionField(eager = false)
    private Collection<Foo> result;

    // getters and setters
    ...
}