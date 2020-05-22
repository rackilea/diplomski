@Component
@Aspect
public class SystemArchitecture {

    @Pointcut("execution(* org.mywebapp.controller..*.*(..))")
    public void businessController() {
    }
}