public class MyDaoSingletonFactoryIsh {
    @PersistenceContext(unitName = "pu2")
    private EntityManager em; // Injected by Spring

    private static TheDaoThatICannotModify dao = null;

    public TheDaoThatICannotModify getDAO() {
        if (dao == null) {
            dao = new TheDaoThatICannotModify();
            dao.setEntityManager(em);
        }
        return dao;
    }
}