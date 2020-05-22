import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.core.Ordered;

@Aspect
public class CustomAspect implements Ordered {

    @Around(value = "@annotation(CustomAnnotation)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
    ... 
    }
    ....

    @Override
    public int getOrder() { 
        return [Order for @CustomAnnotation];
    }

    ....

}