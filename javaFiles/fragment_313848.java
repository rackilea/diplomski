class DefaultService implements MyService {

    private final EntityManagerFactory emf;

    // Inject RegistrationRepository and UserDetailsManager...

    @Inject
    public DefaultService(EntityManagerFactory emf, ...) {
        // ...
        this.emf = emf;
    }

    @Override
    @Transactional
    public void serviceMethod(UUID uuid, String username) {
        registrationsRepository.delete(uuid);

        // Flush the entity manager to remove this record from the DB first.
        EntityManagerHolder entityManagerHolder = (EntityManagerHolder) TransactionSynchronizationManager.getResource(emf);
        entityManagerHolder.getEntityManager().flush();

        // These will be JDBC calls, 'users' are not managed entities
        userDetailsManager.deleteUser(username);
    }
}