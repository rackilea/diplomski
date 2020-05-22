public class RepositoryBaseImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements RepositoryBase<T, ID> {

    private MessageLocale messageLocale;
    private EntityManager entityManager;

    //if you are using IntelliJ, it can show you an error saying "Could not autowire. No beans of JpaEntityInformation". It is just a bug in IntelliJ
    public RepositoryBaseImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager, MessageLocale messageLocale) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.messageLocale = messageLocale;
    }

    //... My custom methods here