/**
 * Verifying all changelog files separately before application startup.
 * 
 * Will log roll forward and roll back SQL if needed 
 * 
 * @author artur
 *
 */
public class DBChangelogVerifier extends ComparableGuiceyBundle {

    private static final String ID = "BUNDLEID";

    private static final Logger log = Logger.getLogger(DBChangelogVerifier.class);

    private List<LiquibaseConfiguration> configs = new ArrayList<>();

    public void addConfig(LiquibaseConfiguration configuration) {
        this.configs.add(configuration);
    }


    /**
     * Attempts to verify all changelog definitions with the provided datasource
     * @param ds
     */
    public void verify(DataSource ds) {
        boolean throwException = false;
        Contexts contexts = new Contexts("");
        for(LiquibaseConfiguration c : configs) {
            try(Connection con = ds.getConnection()) {
                    Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(con));
                    db.setDatabaseChangeLogLockTableName(c.changeLogLockTableName());
                    db.setDatabaseChangeLogTableName(c.changeLogTableName());
                    Liquibase liquibase = new ShureviewNonCreationLiquibase(c.liquibaseResource(), new ClassLoaderResourceAccessor(), db);
                    liquibase.getLog();
                    liquibase.validate();
                    List<ChangeSet> listUnrunChangeSets = liquibase.listUnrunChangeSets(contexts, new LabelExpression());

                    if(!listUnrunChangeSets.isEmpty()) {
                        StringWriter writer = new StringWriter();
                        liquibase.update(contexts, writer);
                        liquibase.futureRollbackSQL(writer);
                        log.warn(writer.toString());
                        throwException = true;
                    }
            } catch (SQLException | LiquibaseException e) {
                throw new RuntimeException("Failed to verify database.", e);
            }
        }

        if(throwException){
            throw new RuntimeException("Unrun changesets in chengelog.");
        }
    }

    /**
     * Using init to process and validate to avoid starting the application in case of errors. 
     */
    @Override
    public void initialize(GuiceyBootstrap bootstrap) {
        Configuration configuration = bootstrap.configuration();
        if(configuration instanceof DatasourceConfiguration ) {
            DatasourceConfiguration dsConf = (DatasourceConfiguration) configuration;
            ManagedDataSource ds = dsConf.getDatasourceFactory().build(bootstrap.environment().metrics(), "MyDataSource");
            verify(ds);
        }
    }

    @Override
    public String getId() {
        return ID;
    }

}