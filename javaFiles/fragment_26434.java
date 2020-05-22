@Component
@Aspect
public class MyRepositoryAuditor {

    // pointcut on all methods with any arguments inside MyRepository
    @Pointcut("execution(public * example.jpa.repositories.MyRepository.*(..) )")
    public void publicRepositoryMethod() {
    }

    // if they return normally
    @AfterReturning("publicRepositoryMethod()")
    public void publicRepositoryMethod(JoinPoint jp) throws Throwable {

        String methodName = jp.getSignature().getName();

        .... perform logging ....
    }
}