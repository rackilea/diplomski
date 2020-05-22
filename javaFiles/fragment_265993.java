public class DataInitializer {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private PlatformTransactionManager txManager;


    @PostConstruct
    public void populate(){

        TransactionTemplate template = new TransactionTemplate(txManager);
        template.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                User user = new User();
                //set user props ...
                manager.merge(user);
                return null;
            }
        });
    }
}