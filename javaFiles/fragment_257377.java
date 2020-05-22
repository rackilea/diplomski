public class DriverStub implements Driver {
    static {
        java.sql.DriverManager.registerDriver(new DriverStub());
    }
    ...
}