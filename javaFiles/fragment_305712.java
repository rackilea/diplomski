public class DAOProvider<T> implements Provider<T> {

  private @Inject Handle handle;
  private final Class<T> daoType;

  public DAOProvider(Class<T> daoType) {
    this.daoType = daoType;
  }

  @Override public T get() {
    return handle.attach(daoType);
  }
}