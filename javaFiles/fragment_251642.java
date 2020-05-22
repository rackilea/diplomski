@Override
public void contextInitialized(ServletContextEvent arg) {
    try {
        DriverManager.registerDriver(new AppEngineDriver());
    } catch (SQLException e) {
        e.printStackTrace();
    }
}