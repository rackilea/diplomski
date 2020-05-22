public class MyJpaRepositoryFactory extends JpaRepositoryFactory {

    private EntityManager entityManager;
    private MessageLocale messageLocale;

    public MyJpaRepositoryFactory(EntityManager entityManager, MessageLocale messageLocale) {
        super(entityManager);
        this.entityManager = entityManager;
        this.messageLocale = messageLocale;
    }

    //****************** Edit ********************
    //starting from spring boot 2.1.0, getTargetRepository(RepositoryInformation information) was made final. So you can't override it anymore. You will need to override getTargetRepository(RepositoryInformation information, EntityManager entityManager)
    //@Override
    //protected Object getTargetRepository(RepositoryInformation information) {
    //    return new RepositoryBaseImpl(getEntityInformation(information.getDomainType()), entityManager, messageLocale);
    //}
    @Override
    protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
        return new RepositoryBaseImpl(getEntityInformation(information.getDomainType()), entityManager, messageLocale);
    }
    //****************** End Edit ******************** 
}