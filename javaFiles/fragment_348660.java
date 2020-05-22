factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
EntityManager em = factory.createEntityManager();
Query q = em.createNativeQuery("SELECT a.firstname, a.age FROM Author a");
List<Object[]> authors = q.getResultList();
for (Object[] a : authors) {
    String first = (String)a[0];
    int last = (int)a[1];
}