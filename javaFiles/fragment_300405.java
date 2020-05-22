package pmo.domain.entities;

public class ExampleTest {
    public static void Main(String[] args) {
        Unit unit1 = new Unit(0, "Unit 1");
        Unit unit2 = new Unit(1, "Unit 2");
        Unit unit3 = new Unit(2, "Unit 3");

        unit2.addUnit(unit3);
        unit1.addUnit(unit2);

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Test");
        PersistanceManager pm = pmf.getPersistenceManager();

        Transaction transaction = pm.currentTransaction();

        try {
            transaction.begin();
            pm.makePersistent(unit1);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            pm.close();
        }
    }
}