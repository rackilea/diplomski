@Singleton
public class OnStartup {

    @Inject
    public OnStartup(final Configuration configuration, final Environment environment, Database db) {


        // Create views
            Logger.info("Creating / Replacing the Tables views in database");
            InputStream is = environment.classLoader().getResourceAsStream("db_views/create_views.sql");
            String sql;
            try {
                sql = IOUtils.toString(is);
                if (sql != null) {
                    Connection conn = db.getConnection();
                    try {
                        Statement stmt = conn.createStatement();
                        try {
                            stmt.execute(sql);
                            Logger.info("Views Created");
                        } finally {
                            try {
                                stmt.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (SQLException e) {
                        Logger.error("Could create Statement ");
                        e.printStackTrace();
                    } finally {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                Logger.error("Could not find create view script");
                e.printStackTrace();
            }
    }
}