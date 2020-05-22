IMethodBinding methodBinding = methodInvocation.resolveMethodBinding();
    Class<?> clazz = retrieveTypeClass(methodBinding.getDeclaringClass());
    Class<?>[] paramClasses = new Class<?>[methodInvocation.arguments().size()];
    for (int idx = 0; idx < methodInvocation.arguments().size(); idx++) {
        ITypeBinding paramTypeBinding = methodBinding.getParameterTypes()[idx];
        paramClasses[idx] = retrieveTypeClass(paramTypeBinding);
    }
    String methodName = methodInvocation.getName().getIdentifier();
    Method method;
    try {
        method = clazz.getMethod(methodName, paramClasses);
    } catch (Exception exc) {
        throw new RuntimeException(exc);
    }

private Class<?> retrieveTypeClass(Object argument) {
    if (argument instanceof SimpleType) {
        SimpleType simpleType = (SimpleType) argument;
        return retrieveTypeClass(simpleType.resolveBinding());
    }
    if (argument instanceof ITypeBinding) {
        ITypeBinding binding = (ITypeBinding) argument;
        String className = binding.getBinaryName();
        if ("I".equals(className)) {
            return Integer.TYPE;
        }
        if ("V".equals(className)) {
            return Void.TYPE;
        }
        try {
            return Class.forName(className);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
    if (argument instanceof IVariableBinding) {
        IVariableBinding variableBinding = (IVariableBinding) argument;
        return retrieveTypeClass(variableBinding.getType());
    }
    if (argument instanceof SimpleName) {
        SimpleName simpleName = (SimpleName) argument;
        return retrieveTypeClass(simpleName.resolveBinding());
    }
    throw new UnsupportedOperationException("Retrieval of type " + argument.getClass() + " not implemented yet!");
}