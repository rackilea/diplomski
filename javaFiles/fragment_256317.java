public class MyRepositoryImpl<SiteDTO, ID extends Serializable>
  extends SimpleJpaRepository<SiteDTO, ID> implements MyRepository<SiteDTO, ID> {

  private EntityManager entityManager;

  // There are two constructors to choose from, either can be used.
  public MyRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
    super(domainClass, entityManager);

    // This is the recommended method for accessing inherited class dependencies.
    this.entityManager = entityManager;
  }

  public List<SiteDTO> executeSiteQuery(List<String> longitudesToMatch, List<String> latitudesToMatch) {
    // Here you can grab the session from the entity manager and create your own query
  }
}