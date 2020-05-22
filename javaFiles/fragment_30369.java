@PersistenceContext
    protected EntityManager entityManager;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void persist(Object o) throws IOException {
         entityManager.persist(o);
    }