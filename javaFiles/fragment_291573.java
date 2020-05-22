@PersistenceContext(unitName = "MyDB")
private EntityManager em;

@Autowired
private AbstractRoutingDataSourceMyDB routingSource;

public void someMethod(int id) {
    em.flush();
    em.clear();
    routingSource.setDbConnectionMyDB("db1");
    em.remove(em.getReference(Something.class, id)); // delete something in db1

    em.flush();
    em.clear();
    routingSource.setDbConnectionMyDB("db2");
    em.remove(em.getReference(Something.class, id)); // delete something else with the same id in db2
}