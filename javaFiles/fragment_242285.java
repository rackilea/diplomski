public interface ReadOnlyRepository<T, ID extends Serializable> extends Repository<T, ID> {

  T findOne(ID id);

  Iterable<T> findAll();
}