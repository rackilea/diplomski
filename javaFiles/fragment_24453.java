public class SomeDriver implements Driver {

    static {
        DriverManager.registerDriver(new SomeDriver());
    }

}