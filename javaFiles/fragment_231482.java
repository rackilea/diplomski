package org.loggable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Loggable
@Interceptor
public class LoggableInterceptor {

    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        Logger logger = Logger.getLogger(context.getTarget().getClass().getSimpleName());

        logger.info("Starting method: " + context.getMethod().getName());
        Object response = context.proceed();
        logger.info("Finished method: " + context.getMethod().getName());
        return response;

    }
}