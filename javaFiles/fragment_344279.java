@Configuration
@Aspect
public class MyAspect {
    @Value("${mycompany.property}")
    private String myKey;

    @Around("execution(public * com.mycompany.NotASpringean.getProperty())")
    public String weave(ProceedingJoinPoint jp) throws Throwable {
        String value = (String) jp.proceed();
        // transform the value thx to injected myKey value
        return value;
    }

    @Bean("post-construct-aspect")
    public MyAspect init() {
        return MyAspect.aspectOf(); // get existing instance via factory method
    }

    private static MyAspect instance = new MyAspect();
    /** Singleton pattern used by LTW then Spring */
    public static MyAspect aspectOf() {
        return instance;
    }
}