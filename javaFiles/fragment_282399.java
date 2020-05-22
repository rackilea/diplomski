@Entity
@Table(schema = "test", name = "a")
public final class A {

  @Id
  public int id;

  @Basic
  public String data;

  @ManyToMany(targetEntity = B.class,
              cascade = CascadeType.ALL,
              fetch = FetchType.LAZY)
  @JoinTable(schema = "test",
             name = "a_has_b",
             joinColumns = @JoinColumn(table = "a",
                                       name = "a_id",
                                       referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(table = "b",
                                              name = "b_id",
                                              referencedColumnName = "id"))
  public Set<B> bs = Sets.newLinkedHashSet();

  @Override
  public String toString() {
    return "A{id=" + id + ", data=" + data + "}";
  }
}