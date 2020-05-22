@Entity
@Table(schema = "test", name = "b")
public final class B {

  @Id
  public int id;

  @Basic
  public String data;

  // omitting mappedBy results in a uni-directional relationship
  @ManyToMany(targetEntity = A.class,
              cascade = CascadeType.ALL,
              fetch = FetchType.LAZY,
              mappedBy = "bs")
  public Set<A> as = Sets.newLinkedHashSet();

  @Override
  public String toString() {
    return "B{id=" + id + ", data=" + data + "}";
  }
}