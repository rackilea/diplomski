@Entity
public class A {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @OneToMany(mappedBy="a")
  private List<B> listB = new ArrayList<B>();
  ...
}

@Entity
public class B {
    @EmbeddedId
    private BId id;

    @ManyToOne
    @MapsId("idA")
    private A a;
    ...
}

@Embeddable
public class BId {
    private int idA;
    private String att;
    ...
}