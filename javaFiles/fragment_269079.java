@Aspect
@Component
public class MyAspect{

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(* com.linda.dao.strategy.*.*(..))")
    public void strategyMethods() { }

    @Pointcut("execution(* com.linda.controller.*.*(..)) || execution(* com.linda.Manager.*(..))")
    public void controllerMethods(){  }

    @Around("strategyMethods()")
    public Object profileStrategyMethods(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();
        Object output = null;
        LOGGER.info("Class:"+pjp.getTarget().getClass()+" entry -> method ->"+pjp.getSignature().getName());
        try{
            output = pjp.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            LOGGER.info("Method execution time: " + elapsedTime + " milliseconds.");
            LOGGER.info("Class:"+pjp.getTarget().getClass()+" exit -> method ->"+pjp.getSignature().getName());
        }catch(Throwable t){
            throw new InternalServerException(t.getMessage());  
        }

        return output;
    }

    @AfterThrowing(pointcut="execution(* com.linda.dao.strategy.*.*(..)) || execution(* com.linda.controller.*.*(..)) || execution(* com.linda.Manager.*(..))",throwing = "ex")
    public void doRecoveryActions(JoinPoint joinPoint, Throwable ex) {

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String stuff = signature.toString();
        String arguments = Arrays.toString(joinPoint.getArgs());
        LOGGER.error("Write something in the log... We have caught exception in method: "
                + methodName + " with arguments "
                + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
                + ex.getMessage());
    }
}