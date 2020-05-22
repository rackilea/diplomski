final String methodName = pjp.getSignature().getName();
final MethodSignature methodSignature = (MethodSignature)pjp.getSignature();
Method method = methodSignature.getMethod();
if (method.getDeclaringClass().isInterface()) {
    method = pjp.getTarget().getClass().getDeclaredMethod(methodName, method.getParameterTypes());    
}