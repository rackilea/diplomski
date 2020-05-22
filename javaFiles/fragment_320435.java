@Entity
public class Foo{
    @OneToMany(mappedBy = "foo", orphanRemoval = true)
    private List<FooProperties> fooProperties;

    public FooProperties getFooProperties() {
        if (fooProperties == null || fooProperties.isEmpty()) return null;
        else return fooProperties.get(0);
    }

    public void setFooProperties(FooProperties newFooProperties) {
        if (fooProperties == null) fooProperties = new ArrayList<FooProperties>();
        else fooProperties.clear();
        if (newFooProperties != null)
            fooProperties.add(newFooProperties);            
    }
    ...
}

@Entity
public class FooProperties{
    @ManyToOne
    @JoinColumn(name = "foo_id",  nullable = false)
    private Foo foo;
    ...
}