public class PGService {
    private final Sql2o connectionPool;

    public PGService() throws ConfigurationException, IOException {
        Config cfg = loadConfig("dbconfig.json");
        if (cfg == null) {
            throw new ConfigurationException("Could not load dbconfig.");
        }
        BasicDataSource bds = new BasicDataSource();
        bds.setUsername(cfg.getUsername());
        bds.setPassword(cfg.getPassword());
        bds.setDriverClassName("org.postgresql.Driver");
        bds.setUrl(cfg.getUrl());
        bds.setInitialSize(1);
        connectionPool = new Sql2o(bds);
    }

    public Connection getConnection() {
        return this.connectionPool.open();
    }
}