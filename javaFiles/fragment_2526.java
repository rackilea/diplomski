package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public final class MethodRepeater {

    @Around("execution(* spring.aop..*(..)) && @annotation(retryOnFailure)")
    public Object wrap(final ProceedingJoinPoint joinPoint, RetryOnFailure retryOnFailure) throws Throwable {
        System.out.println(joinPoint);
        return proceed(joinPoint, retryOnFailure);
    }

    private Object proceed(ProceedingJoinPoint joinPoint, RetryOnFailure retryOnFailure) throws Throwable {
        int attempt = 1;
        while (true) {
            try {
                return joinPoint.proceed();
            } catch (final Throwable ex) {
                System.out.println("Try #" + attempt + " failed: " + ex);
                if (++attempt >= retryOnFailure.attempts())
                    return "OK";
                if (retryOnFailure.delay() > 0L)
                    retryOnFailure.unit().sleep(retryOnFailure.delay());
            }
        }
    }
}