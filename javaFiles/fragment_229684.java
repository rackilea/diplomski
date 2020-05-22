@Transient
private boolean persisted;

@PostLoad
@PostPersist
public void setPersisted() {
  persisted = true;
}