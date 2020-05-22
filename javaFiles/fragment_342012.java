public void connect(ConnectionSettingsModel conSet) throws Exception {

    try( Connection con = DriverManager.getConnection( conSet.getUrl(), conSet.getUser(), conSet.getPassword() ) ) {
        /* Nothing to do here, really... */
    } catch ( Exception e ) {
        System.out.println("Trouble connecting with DBMS, please check database url, username, and password.");
        throw e;  
    }

    Map<String, String> connectionProperties = new HashMap<>();
    connectionProperties.put("javax.persistence.jdbc.url", conSet.getUrl());
    connectionProperties.put("javax.persistence.jdbc.user", conSet.getUser());
    connectionProperties.put("javax.persistence.jdbc.password", conSet.getPassword());
    connectionProperties.put("hibernate.default_schema", conSet.getSchema());


    System.out.println("Before creating EM");
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres-connect", connectionProperties);
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    System.out.println("After creating EM");
 }