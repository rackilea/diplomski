@Entity
public class A {
  @ManyToOne
  private B b;

  @OneToMany
  private Collection<C> cs;
}