import org.aopalliance.aop.Advice;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component
public class AuthorisationAspect implements Advice {

    private final static Logger logger = Logger.getLogger(AuthorisationAspect.class);

    @Autowired
    MyService myService;

    @SuppressWarnings("unchecked")
    @AfterReturning(pointcut = "@annotation(com.example.ApplyAuthorisationAdvice)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        if (result != null && (result instanceof List)) {
            // filter stuff
        }

    }
}