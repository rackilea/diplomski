@Produces
@RequestScoped
public EntityManager createEntityManager() {
   return Persistence.createEntityManagerFactory("mgr").createEntityManager();
}

public void closeEM(@Disposes EntityManager manager) {
   manager.close();
}