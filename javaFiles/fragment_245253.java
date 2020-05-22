@NoRepositoryBean
public interface QueryableReadRepository<T> extends Repository<T, String> {

  List<T> findAll(Predicate predicate);

  List<T> findAll(Sort sort);

  List<T> findAll(Predicate predicate, Sort sort);

  List<T> findAll(OrderSpecifier<?>... orders);

  List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

  Page<T> findAll(Pageable page);

  Page<T> findAll(Predicate predicate, Pageable page);

  Optional<T> findOne(Predicate predicate);

  boolean exists(Predicate predicate);
}