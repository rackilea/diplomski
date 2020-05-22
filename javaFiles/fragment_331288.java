@Aspect
@Component("auditAspect")
public class AuditAspect implements ApplicationContextAware {

ApplicationContext context;

public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    // do stuff with context here
}

public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;       
 }