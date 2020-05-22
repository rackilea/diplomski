private EntityManager em = createManager();
private EntityTransaction utx = em.getTransaction();

final Peeps entity = new Peeps();
entity.setName("Joe");
utx.begin();
em.persist(entity);
utx.commit();