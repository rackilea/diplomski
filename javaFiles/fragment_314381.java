abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID> {

  private @Transient boolean isNew = true;

  @Override
  public boolean isNew() {
    return isNew;
  }

  @PostPersist
  @PostLoad
  void markNotNew() {
    this.isNew = false;
  }
}