@Service
public class AnyBean  {
  @Autowired
  private PlatformTransactionManager transactionManager;
  @Autowired
  private SessionFactory sessionFactory;

  @PostConstruct
  private void init() {
    TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
    transactionTemplate.execute(new TransactionCallback<Object>() {
      @Override
      public Object doInTransaction(TransactionStatus transactionStatus) {
        // HERE YOU CODE
        for(EnumRole role:EnumRole.values())
        {
          Role r = getRoleByName(role);
          if(r==null)
          {
            r=new Role();
            r.setName(role);
            r.setDescription(role.getDescription());
            sessionFactory.getCurrentSession().save(r);
          }
        }            
        return null;
      }
    });
  }
}