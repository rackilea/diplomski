public class EntityManagerFactory {

    public EntityManager create() {
        return EntityController.getEntityManager();
    }
}