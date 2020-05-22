public static void main(String[] args) throws Exception{
        LocateRegistry.createRegistry(1099);
        ConnectionPoolDataSource dataSource = createDataSource("root", "");

        InitialContext context = createContext();
        context.bind("MysqlMyDS", dataSource);
        System.out.println("context created!");

    }

    private static InitialContext createContext() throws NamingException {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, "rmi://localhost:1099");
        InitialContext context = new InitialContext(env);
        return context;
    }

    private static ConnectionPoolDataSource createDataSource(String username, String password) {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("test");
        return dataSource;
    }