public class MyServiceImpl extends PersistentRemoteService implements MyService {


  public MyServiceImpl() {

    EntityManagerFactory emf = EMF.get();

    HibernateJpaUtil hibernateJpaUtil = new HibernateJpaUtil();
    hibernateJpaUtil.setEntityManagerFactory(emf);

    PersistentBeanManager persistentBeanManager =
      GwtConfigurationHelper.initGwtStatelessBeanManager(hibernateJpaUtil);

    setBeanManager(persistentBeanManager);
  }

  // Service methods follow here

}