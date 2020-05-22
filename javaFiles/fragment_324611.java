@Autowired
  EntityManagerFactory entityManagerFactory;

  private static EntityManager entityManager;

  public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
    entityManager=entityManagerFactory.createEntityManager();
    this.entityManagerFactory = entityManagerFactory;
  }