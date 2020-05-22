import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.interceptor.Interceptor;
import org.mule.processor.AbstractInterceptingMessageProcessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <code>TimerInterceptor</code> simply times and displays the time taken to
 * process an event.
 */
public class TimerInterceptor extends AbstractInterceptingMessageProcessor
        implements Interceptor {
    /**
     * logger used by this class
     */
    private static Log logger = LogFactory.getLog(TimerInterceptor.class);

    public MuleEvent process(MuleEvent event) throws MuleException {
        long startTime = System.currentTimeMillis();

        MuleEvent resultEvent = processNext(event);

        if (logger.isInfoEnabled()) {
            long executionTime = System.currentTimeMillis() - startTime;
            logger.info("Custom Timer : "+resultEvent.getFlowConstruct().getName() + " took "
                    + executionTime + "ms to process event ["
                    + resultEvent.getId() + "]");
        }

        return resultEvent;
    }
}