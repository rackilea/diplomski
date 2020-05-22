import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

public class ConditionalExcecution {

    public static void main(String[] args) {
        ControlSlave controlSlave1 = new ControlSlave();
        controlSlave1.usable = true;
        System.out.println(controlSlave1.sum(1, 2));
        controlSlave1.print("HelloWorld");

        ControlSlave controlSlave2 = new ControlSlave();
        System.out.println(controlSlave2.sum(1, 2));
        controlSlave2.print("HelloWorld");
    }

}

/**
 * Conditional Method Execution Class
 * @author AmithKumar
 *
 */
@Conditional
class ControlSlave {
    boolean usable;

    public int sum(int a, int b) {
        return a + b;
    }

    public void print(String s) {
        System.out.println(s);
    }
}

/**
 * Annotation to mark class usable
 * @author AmithKumar
 *
 */
@Target({ElementType.TYPE})
@Retention(RUNTIME)
@interface Conditional {
}

@Aspect
class ControlMaster {

    /**
     * decision controller to check condition to continue method execution
     * 
     * @param proceedingJoinPoint
     * @return Object
     * @throws Throwable
     */
    @Around("execution(* *(..)) && @within(Conditional)")
    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // get object
        ControlSlave controlSlave = (ControlSlave) proceedingJoinPoint.getThis();
        if (controlSlave.usable) {
            return proceedingJoinPoint.proceed();
        } else {
            return null;
        }
    }
}