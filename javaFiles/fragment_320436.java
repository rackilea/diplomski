@Entity
public class Foo{
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "foo_id",  nullable = false)        
    private List<FooProperties> fooProperties;

    // getter/setter as above
    ...
}