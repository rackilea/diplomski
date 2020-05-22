@Transactional
public void addServer(Server server) {
    EntityManager em = emf.createEntityManager();
    emf.createEntityManager().persist(server);
    em.close();
}