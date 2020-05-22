private static final long serialVersionUID = -1752491307148335890L;

private static final String PU_UNIT="ps_unitname";

 public CustomJPA(Class<T> entityClass, String persitenceUnitName) {
           super(entityClass);
           EntityManager  entityManager = JPAContainerFactory.createEntityManagerForPersistenceUnit(persitenceUnitName);
           setEntityProvider(new CachingMutableLocalEntityProvider<T>(entityClass,entityManager));
     }

public CustomJPA(Class<T> entityClass) {
      super(entityClass);
      EntityManager  entityManager =JPAContainerFactory.createEntityManagerForPersistenceUnit(PU_UNIT);
      setEntityProvider(new CachingMutableLocalEntityProvider<T>(entityClass,entityManager));
   }