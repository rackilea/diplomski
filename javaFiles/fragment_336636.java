public Object invoke(Object obj, Object[] args)
        throws IllegalArgumentException, InvocationTargetException {
    if (++numInvocations > ReflectionFactory.inflationThreshold()) {
        MethodAccessorImpl acc = (MethodAccessorImpl) new MethodAccessorGenerator()
                .generateMethod(method.getDeclaringClass(), method
                        .getName(), method.getParameterTypes(),
                        method.getReturnType(), method
                                .getExceptionTypes(), method
                                .getModifiers());
        parent.setDelegate(acc);
    }

    return invoke0(method, obj, args);
}