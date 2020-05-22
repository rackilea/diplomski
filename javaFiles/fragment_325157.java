public class MyRepositoryCustomImpl implements MyRepositoryCustom {

    @PersistenceContext(unitName = "yourPersistenceUnitName")
    private EntityManager em;

    List<Sapf> find(String query) {
        Query query = em.createNativeQuery(query, Sapf.class);
        return query.getResultList();
    }
}