public class CustomRepositoryFactoryBean<T extends Repository<S, I>, S, I>
    extends JpaRepositoryFactoryBean<T, S, I> {

  public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
    super(repositoryInterface);
  }

  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
    return new CustomRepositoryFactory(entityManager);
  }