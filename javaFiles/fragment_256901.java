@Aspect
@Component
public class GlobalFilter {

    @Autowired
    SessionParam sessionParam;


    @Pointcut("execution(* org.hibernate.SessionFactory.getCurrentSession(..))")
    protected void hibernateSessionFetch(){

    }

    @AfterReturning(pointcut = "hibernateSessionFetch()", returning = "result")
    public void enableGlobalFilter(JoinPoint joinPoint, Object result){

        Session session = (Session) result;

        session.enableFilter("GLOBAL_FILTER").setParameter("sessParam", sessionParam.getSessParam());

    }
}