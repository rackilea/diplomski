public abstract class AbstractLogger {

    protected Logger log;
    protected Class callingClass;
    public AbstractLogger(Class c)
    {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.callingClass = c;
    }

    public void log(String s)
    {
        log.debug(this.callingClass + " :" + s);
    }

}

public class LoggerOne extends AbstractLogger {    

    public LoggerOne(Class c) {
        super(c);           
    }

}

public class LoggerTwo extends AbstractLogger {   

    public LoggerTwo(Class c) {
        super(c);           
    }    

}

public class LoggerThree extends AbstractLogger {    

    public LoggerThree(Class c) {
        super(c);           
    }    
}