import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class MyClass
{
    public static Logger mLogger = Logger.getLogger(MyClass.class.getName());

    public static void main(String[] args)
    {
        System.setProperty("test", "hello");
        PropertyConfigurator.configure("./log4j.properties");

        mLogger.debug("Hello world!");

        // modify variable and re-configure
        System.setProperty("test", "bye");
        PropertyConfigurator.configure("./log4j.properties");

        mLogger.debug("byebye");
    }
}