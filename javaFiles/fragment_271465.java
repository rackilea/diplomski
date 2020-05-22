class ResourceNotFoundMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        ResourceNotFound resourceNotFound = method.getAnnotation(ResourceNotFound.class);
        //...
        Object result = invocation.proceed();
        //...
        return result;
    }
}