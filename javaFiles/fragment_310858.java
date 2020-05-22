public class C{

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "z")
    private A a;

}

public class A{

    @OneToMany(mappedBy = "a"
    @JoinColumn(name = "z", referencedColumnName = "id")
    private List<C> cCollection;

}