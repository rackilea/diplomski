public static class SessionCustomizer implements org.eclipse.persistence.config.SessionCustomizer {
    @Override
    public void customize(Session session) throws Exception {
        DatabaseLogin databaseLogin = (DatabaseLogin) session.getDatasourceLogin();
        databaseLogin.setTransactionIsolation(DatabaseLogin.TRANSACTION_SERIALIZABLE);
    }
}

private void init() {
    entityManagerFactoryRegular = Persistence.createEntityManagerFactory("MyPersitenceRegular");
    Map<String, String> props = new HashMap<>();
    props.put(PersistenceUnitProperties.SESSION_CUSTOMIZER, SessionCustomizer.class.getName());
    entityManagerFactoryTransactionSerializable = Persistence.createEntityManagerFactory("MyPersitenceTransactionSerializable", props);
}