package de.scrum_master.aspect;

import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import de.scrum_master.app.ThrottlingException;

@Aspect
public class ThrottlingInterceptor {
    private static final Random RANDOM = new Random();

    @Before("execution(* doSomething())")
    public void invoke(JoinPoint thisJoinPoint) throws ThrottlingException {
        System.out.println(getClass().getSimpleName() + " -> " + thisJoinPoint);
        if (isThrottled()) {
            throw new ThrottlingException("call throttled");
        }
    }

    private boolean isThrottled() {
        return RANDOM.nextInt(3) > 0;
    }
}