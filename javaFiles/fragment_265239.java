@Aspect
public class LogoutAdvice {

    @AfterThrowing(throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, LoginException e) {    
        System.out.println("IDS HABBENING");
    }
}