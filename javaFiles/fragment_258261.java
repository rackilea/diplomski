public abstract class MySuperClass {

    protected void demoLog() {
        logger().debug("My message");
    }

    protected abstract Logger logger();
}

public class MyClass extends MySuperClass {

    private static final Logger LOGGER = LogManager.getLogger();

    public void executeLog() {
        demoLog();
    }

    @Override
    protected Logger logger() {
        return LOGGER;
    }
}