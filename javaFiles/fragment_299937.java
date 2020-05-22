import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Aspect
@PropertySource(value= {"classpath:log4j.properties"})
public class LogginAspect {

    Logger logger =  LoggerFactory.getLogger(LogginAspect.class);

    @Before("within(com.web.casemanager..*)")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Inside "+ joinPoint.getSignature().getDeclaringTypeName() + " --> " + joinPoint.getSignature().getName() + " --> Enter");
    }

    @After("within(com.web.casemanager..*)")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Inside "+ joinPoint.getSignature().getDeclaringTypeName() + " --> " + joinPoint.getSignature().getName()  + " --> Exit");
    }
}