package de.scrum_master.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;

import de.scrum_master.app.ThrottlingException;

@Aspect
@DeclarePrecedence("RetryInterceptor, *")
public class RetryInterceptor {
    private static int MAX_TRIES = 5;
    private static int WAIT_MILLIS_BETWEEN_TRIES = 1000;

    @Around("execution(* doSomething())")
    public Object invoke(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        System.out.println(getClass().getSimpleName() + " -> " + thisJoinPoint);
        ThrottlingException throttlingException = null;
        for (int i = 1; i <= MAX_TRIES; i++) {
            try {
                return thisJoinPoint.proceed();
            }
            catch (ThrottlingException e) {
                throttlingException = e;
                System.out.println("  Throttled during try #" + i);
                Thread.sleep(WAIT_MILLIS_BETWEEN_TRIES);
            }
        }
        throw throttlingException;
    }
}