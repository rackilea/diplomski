@Entity
public class A extends Model {

    @Id
    private Long id;

    @OneToOne(optional = true, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private B b;

 ...
}


@Entity
public class B extends Model {

    @Id
    private Long id;

    @OneToOne(optional = false, mappedBy = "b")
    private A a;

    private String name;

    ...
}