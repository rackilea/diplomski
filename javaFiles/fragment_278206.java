public interface FooDao
{
  public Collection<Foo> getAll() throws DaoException;

  public Foo getByIdentity(String id) throws DaoException;

  public Collection<Foo> getByName(String name) throws DaoException;

  public void save(Collection<Foo> foos) throws DaoException;
}