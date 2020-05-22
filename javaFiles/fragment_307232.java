@MappedSuperclass
public abstract class AbstractEntity<ID extends SalespointIdentifier> implements Persistable<ID> {

  private @Transient boolean isNew = true;

  @Override
  public boolean isNew() {
    return isNew;
  }


  @PrePersist
  @PostLoad
  void markNotNew() {
    this.isNew = false;
  }

  // More code…
}