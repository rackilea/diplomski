Object result = joinPoint.proceed();
if (log.isDebugEnabled()) {
    log.debug("Exit: {}.{}() with result = {}", 
        joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName(), 
        new ObjectMapper().writeValueAsString(result));
}