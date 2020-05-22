import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//REMOVE THIS: import org.apache.commons.logging.impl.Log4JLogger;

public class Log4JEnhancedCoverage implements Log {

    private static final long serialVersionUID = -8715529047111858959L;

    private final Log logger;

    private final boolean mavenRun;

    public Log4JEnhancedCoverage(String name) {
        //REMOVE THIS: this.logger = new Log4JLogger(name);
        this.logger = LogFactory.getLog(name);
        ...