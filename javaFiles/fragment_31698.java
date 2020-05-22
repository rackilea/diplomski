package testMaven;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;


@Aspect
public class aspecter {
    @Before("execution(*  testMaven.aaaa.aa(..))")
    public void testBefore(){
        System.out.println("yooi");
    }
}