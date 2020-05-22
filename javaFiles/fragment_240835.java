import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.lookup.MainMapLookup;

public class SomeClass {

    private static final Logger LOG = LogManager.getLogger();   

    public static void main(String[] args){
        MainMapLookup.setMainArguments(args);

        LOG.info("This should appear in default.log");

        args = new String[]{"specialFile"};
        MainMapLookup.setMainArguments(args);
        LOG.info("This should appear in specialFile.log");
    }
}