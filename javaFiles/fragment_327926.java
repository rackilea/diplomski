public class Databases {

    @Produces @Users 
    @PersistenceContext(unitName="UserData")
    EntityManager userEntityManager;

    @Produces @Documents
    @PersistenceContext(unitName="DocumentData")
    EntityManager docDatabaseEntityManager;
}