public class PresentatieDaoImpl implements PresentatieDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }

    public Collection loadProductsByCategory(String category) {
        return entityManager.createQuery("from Product p where p.category = :category")
            .setParameter("category", category).getResultList();
    }
}