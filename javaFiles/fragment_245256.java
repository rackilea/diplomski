public class CustomRepositoryFactory extends JpaRepositoryFactory {

  private final EntityManager entityManager;

  public CustomRepositoryFactory(EntityManager entityManager) {
    super(entityManager);
    this.entityManager = entityManager;
  }

  @Override
  protected RepositoryFragments getRepositoryFragments(RepositoryMetadata metadata) {
    RepositoryFragments fragments = super.getRepositoryFragments(metadata);

    if (QueryableReadRepository.class.isAssignableFrom(
        metadata.getRepositoryInterface())) {

      JpaEntityInformation<?, Serializable> entityInformation = 
          getEntityInformation(metadata.getDomainType());

      Object queryableFragment = getTargetRepositoryViaReflection(
          QueryableReadRepositoryImpl.class, entityInformation, entityManager);

      fragments = fragments.append(RepositoryFragment.implemented(queryableFragment));
    }

    return fragments;
  }