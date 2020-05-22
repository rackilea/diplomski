@Entity
@Immutable
@Table(name = "tb_name")
public final class JpaEntity extends AbstractPersistable<UUID> {
  private static final long serialVersionUID = -1352464759104643303L;

  @Column(name = "column1", length = 128, nullable = false)
  private String one;

  @Column(name = "column2", length = 128, nullable = false)
  private String two;

  private JpaEntity() { } // No-args constructor required by JPA spec

  public JpaEntity(final String one, final String two) {
    this.one = one;
    this.two = two;
  }

  public String getOne() { return one; }

  public String getTwo() { return two; }

  @Override
  public int hashCode() {
    return Objects.hash(one, two);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) { return true; }
    if (!(obj instanceof JpaEntity)) { return false; }
    final JpaEntity entity = (JpaEntity) obj;
    return Objects.equals(one, entity.one) &&
        Objects.equals(two, entity.two);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
        .appendSuper(super.toString())
        .append("one", one)
        .append("two", two)
        .toString();
  }
}