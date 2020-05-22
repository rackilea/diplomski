import org.aspectj.lang.*;
import org.apache.log4j.*;

public aspect TraceMethodCalls {
    Logger logger = Logger.getLogger("trace");

    TraceMethodCalls() {
        logger.setLevel(Level.ALL);
    }

    pointcut traceMethods()
        //give me all method calls of every class with every visibility
        : (execution(* *.*(..))
        //give me also constructor calls
        || execution(*.new(..)))
        //stop recursion don't get method calls in this aspect class itself
        && !within(TraceMethodCalls);

    //advice before: do something before method is really executed
    before() : traceMethods() {
        if (logger.isEnabledFor(Level.INFO)) {
            //get info about captured method and log it
            Signature sig = thisJoinPointStaticPart.getSignature();
            logger.log(Level.INFO,
                        "Entering ["
                        + sig.getDeclaringType().getName() + "."
                        + sig.getName() + "]");
        }
    }
}