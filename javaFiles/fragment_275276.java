package de.scrum_master.aspect;

import java.util.concurrent.Callable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;

import de.scrum_master.app.DefaultRetryPolicy;
import de.scrum_master.app.RetryPolicy;
import de.scrum_master.app.RetryingCallable;

@Aspect
@DeclarePrecedence("RetryInterceptor, *")
public class RetryInterceptor {
    private RetryPolicy<Object> retryPolicy = new DefaultRetryPolicy<>();

    @Around("execution(* doSomething())")
    public Object invoke(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        System.out.println(getClass().getSimpleName() + " -> " + thisJoinPoint);
        return RetryingCallable.newRetryingCallable(
            new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return thisJoinPoint.proceed();
                }
            },
            retryPolicy
        ).call();
    }
}