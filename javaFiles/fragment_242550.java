@Aspect
@Component
public class AopValidator {

    @Before("execution(String hello())")
     public void test() throws AuthException{
         throw new AuthException("Exception message from AOP on unauthorized access");
     }
}