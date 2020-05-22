class DriverFactory {
    private static Driver instance;
    public static synchronized Driver getDriver() {
        if (instance == null) {
            instance = GraphDatabase.driver(...);
        }
        return instance;
    }
}