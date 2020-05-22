import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;    

@Aspect
public class SpringAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SpringAspect.class);

    @Before("execution(* sample.package.path.TestRestController.*(..))")
    public void executedMethodsLogger(JoinPoint joinPoint) {
        LOG.info("[ Executed method {} ]", joinPoint.toString());
    }

}