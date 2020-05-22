private EntityManagerFactory createEntNamagerFactoryViaKerberos(byte[] inToken)
            throws Exception {

        System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
        System.setProperty("java.security.auth.login.config", "C:\\krb\\gsslogin\\login.conf");
        System.setProperty("java.security.krb5.conf", "C:\\krb\\krb5.conf");

        Oid mechOid = new Oid("1.2.840.113554.1.2.2");
        GSSManager manager = GSSManager.getInstance();

        //first obtain it's own credentials...
        GSSCredential myCred =
                manager.createCredential(null, GSSCredential.DEFAULT_LIFETIME, mechOid, GSSCredential.ACCEPT_ONLY);

        //...and create a context for this credentials...
        GSSContext context = manager.createContext(myCred);

        //...then use that context to authenticate the calling peer by reading his token
        byte[] tokenForPeer = context.acceptSecContext(inToken, 0, inToken.length);

        if (!context.isEstablished()) {
            throw new Exception("Context not established!");
        }

        //...then obtain information from the context
        logger.debug("Clientcipal is " + context.getSrcName());
        logger.debug("Servercipal is " + context.getTargName());

        if (context.getCredDelegState()) {
            logger.debug("Then is delegatable.");
        } else {
            logger.debug("Then is NOT delegatable");
        }

        GSSCredential clientCr = context.getDelegCred();
        Subject s = GSSUtil.createSubject(clientCr.getName(), clientCr);
        KerberosActionCreateEmf kerberosAction = new KerberosActionCreateEmf();
        kerberosAction.unicalEntFactoryName = "kerb" + System.currentTimeMillis();
        Subject.doAs(s, kerberosAction);
        EntityManagerFactory emf = kerberosAction.emf;
        return emf;

    }



    class KerberosActionCreateEmf implements PrivilegedExceptionAction {

        public EntityManagerFactory emf;

        public String modelName;
        public String unicalEntFactoryName;

        @Override
        public Object run() throws Exception {

            Properties properties = new Properties();
            properties.setProperty("javax.persistence.jdbc.driver", "com.sap.db.jdbc.Driver");
            properties.setProperty("hibernate.connection.url", "jdbc:sap://10.0.0.121:31015");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HANAColumnStoreDialect");

            // do not use login and pass, use kerberos delegation (token)
            //properties.setProperty("hibernate.connection.username", login);
            //properties.setProperty("hibernate.connection.password", pass);

            properties.setProperty("hibernate.default_schema", "default_schema");
            properties.setProperty("hibernate.show_sql", model_manager_hibernate_show_sql);
            properties.setProperty("hibernate.ejb.entitymanager_factory_name", unicalEntFactoryName);
            properties.setProperty("hibernate.cache.use_query_cache", "false");
            properties.setProperty("hibernate.query.plan_cache_max_soft_references", "1");
            properties.setProperty("hibernate.query.plan_cache_max_strong_references", "1");

            properties.setProperty("hibernate.hikari.minimumIdle", "3");
            properties.setProperty("hibernate.hikari.maximumPoolSize", "20");
            properties.setProperty("hibernate.hikari.idleTimeout", "600000");
            properties.setProperty("hibernate.hikari.AutoCommit", "false");
            properties.setProperty("hibernate.hikari.poolName", unicalEntFactoryName);
            properties.setProperty("hibernate.hikari.connectionTimeout", "1800000");

            EntityManagerFactory newEntityManagerFactory =
                    Persistence.createEntityManagerFactory("persistenceUnitName", properties);

            emf = newEntityManagerFactory;
            return null;
        }
    }