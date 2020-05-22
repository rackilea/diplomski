@Transactional
public void addServer(Server server) {
    EntityManager em = emf.createEntityManager();
    em.persist(server);
    em.close();
}