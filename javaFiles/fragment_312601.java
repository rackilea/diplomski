@Indexed
public class Product {
    @Id
    private long id;

    @ManyToMany
    @IndexedEmbedded
    Set<Keyword> keywords;

    // ...
}

public class Keyword {

    @Id
    private long id;

    // only needed if you want a bidirectional relation
    @ManyToMany
    @ContainedIn
    Set<Product> products;

    // ...
}