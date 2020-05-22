interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

  Optional<T> findOne(ID id);

  // declare additional methods if needed
}

interface YourRepository extends BaseRepository<DomainClass, Long> { … }