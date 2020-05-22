public class SpringConfig {

@PersistenceUnit
EntityManagerFactory emf;

@PersistenceContext
EntityManager em;

@Produces
@ApplicationScoped
public EntityManagerFactory createEntityManagerFactory() {
    return this.emf;
}

@Produces
public EntityManager createEntityManager() {
    return this.em;
}

public void close(@Disposes EntityManagerFactory entityManagerFactory) {
    entityManagerFactory.close();
}

public void close(@Disposes EntityManager entityManager) {
    entityManager.close();
}
}