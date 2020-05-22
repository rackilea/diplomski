@Aspect
public class WebFilterMatcher {
    @Pointcut("within(@com.example.WebFilter *)")
    public void beanAnnotatedWithWebFilter() {}

    @Pointcut("execution(boolean com.example..preHandle(..))")
    public void preHandleMethod() {}

    @Pointcut("preHandleMethod() && beanAnnotatedWithWebFilter()")
    public void preHandleMethodInsideAClassMarkedWithWebFilter() {}

    @Around("preHandleMethodInsideAClassMarkedWithWebFilter()")
    public Object beforeFilter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if(args.length > 0) {
            HttpServletRequest request = (HttpServletRequest) args[0];
            Class target = joinPoint.getTarget().getClass();
            if (target.isAnnotationPresent(WebFilter.class)) {
                String[] patterns = ((WebFilter) target.getAnnotation(WebFilter.class)).urlPatterns();
                for (String pattern : patterns) {
                    if (GlobMatcher.match(pattern, request.getRequestURI())) {
                        return joinPoint.proceed();
                    }
                }
            }
        }
        return true;
    }
}