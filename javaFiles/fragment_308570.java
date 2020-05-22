@Aspect
public class GroupIdRetrieverAspect {

    @Before("execution(* com.your.package.*)")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running!");
        //use joinPoint to get called class/method
        //check whether called method has your annotation and retrieve the id
    }

}