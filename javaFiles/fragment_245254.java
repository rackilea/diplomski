@Transactional
public class QueryableReadRepositoryImpl<T> extends QuerydslJpaPredicateExecutor<T>
    implements QueryableReadRepository<T> {

  private static final EntityPathResolver resolver = SimpleEntityPathResolver.INSTANCE;

  private final EntityPath<T> path;
  private final PathBuilder<T> builder;
  private final Querydsl querydsl;

  public QueryableReadRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
      EntityManager entityManager) {
    super(entityInformation, entityManager, resolver, null);
    this.path = resolver.createPath(entityInformation.getJavaType());
    this.builder = new PathBuilder<T>(path.getType(), path.getMetadata());
    this.querydsl = new Querydsl(entityManager, builder);
  }

  @Override
  public Optional<T> findOne(Predicate predicate) {
    return super.findOne(predicate);
  }

  @Override
  public List<T> findAll(OrderSpecifier<?>... orders) {
    return super.findAll(orders);
  }

  @Override
  public List<T> findAll(Predicate predicate, Sort sort) {
    return executeSorted(createQuery(predicate).select(path), sort);
  }

  @Override
  public Page<T> findAll(Predicate predicate, Pageable pageable) {
    return super.findAll(predicate, pageable);
  }

  @Override
  public List<T> findAll(Predicate predicate) {
    return super.findAll(predicate);
  }

  public List<T> findAll(Sort sort) {
    return executeSorted(createQuery().select(path), sort);
  }

  @Override
  public Page<T> findAll(Pageable pageable) {
    final JPQLQuery<?> countQuery = createCountQuery();
    JPQLQuery<T> query = querydsl.applyPagination(pageable, createQuery().select(path));

    return PageableExecutionUtils.getPage(
        query.distinct().fetch(), 
        pageable,
        countQuery::fetchCount);
  }

  private List<T> executeSorted(JPQLQuery<T> query, Sort sort) {
    return querydsl.applySorting(sort, query).distinct().fetch();
  }
}