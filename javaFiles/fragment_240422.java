public class EntityUtil {
  public static void executeWithEntityManager(EntityManagerAction action) {
    EntityManager em = someHowCreateEntityManager();

    EntityTransaction tx = null;
    try {
        action.execute(em);
        tx = em.getTransaction();
    } catch (RuntimeException e) {
        if (tx != null && tx.isActive()) { 
            tx.rollback();
        }
        throw e;
    } finally {
        em.close();
    }
  }
}