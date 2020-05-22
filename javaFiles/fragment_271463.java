class CustomRepositoryFactoryBean<R extends JpaRepository<T, I>, T , I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

  protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
    RepositoryFactorySupport factory = super.createRepositoryFactory(em);
    factory.addRepositoryProxyPostProcessor(new ResourceNotFoundProxyPostProcessor());
    return factory;
  }

}