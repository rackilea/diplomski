String PERSISTENCE_UNIT_NAME = "...";
EntityManagerFactory emf = 
    Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

HibernateJpaUtil hibernateJpaUtil = new HibernateJpaUtil();
hibernateJpaUtil.setEntityManagerFactory(emf);

PersistentBeanManager persistentBeanManager =
    GwtConfigurationHelper.initGwtStatelessBeanManager(hibernateJpaUtil);

setBeanManager(persistentBeanManager);