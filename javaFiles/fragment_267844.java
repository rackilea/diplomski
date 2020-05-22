@Configuration
@ConfigurationProperties(prefix = "spring.jpa.properties.hibernate.jdbc")
public class RepositoryConfiguration {
    private int batchSize;
}

public class MyCustomRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I extends Serializable> extends JpaRepositoryFactoryBean<R, T, I> {

    private RepositoryConfiguration repositoryConfiguration;

    public MyCustomRepositoryFactoryBean(Class<? extends R> repositoryInterface, RepositoryConfiguration repositoryConfiguration) {
        super(repositoryInterface);
        this.repositoryConfiguration = repositoryConfiguration;
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new MyCustomRepositoryFactory(entityManager, repositoryConfiguration);
    }

    private static class MyCustomRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {

        private RepositoryConfiguration repositoryConfiguration;

        MyCustomRepositoryFactory(EntityManager entityManager, RepositoryConfiguration repositoryConfiguration) {
            super(entityManager);
            this.repositoryConfiguration = repositoryConfiguration;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, 
                EntityManager entityManager) {

            JpaEntityInformation<T, ?> entityInformation = 
                    (JpaEntityInformation<T, ?>) getEntityInformation(information.getDomainType());

            return new MyCustomRepositoryImpl<T, I>(
                    entityInformation, 
                    entityManager, 
                    repositoryConfiguration);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return MyCustomRepositoryImpl.class;
        }
    }
}