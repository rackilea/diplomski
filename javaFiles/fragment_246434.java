public void invoke(Object targetObject, Object[] parameters,
        String methodName) {
    for (Method method : targetObject.getClass().getMethods()) {
        if (!method.getName().equals(methodName)) {
            continue;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        boolean matches = true;
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].isAssignableFrom(parameters[i]
                    .getClass())) {
                matches = false;
                break;
            }
        }
        if (matches) {
            // obtain a Class[] based on the passed arguments as Object[]
            method.invoke(targetObject, parametersClasses);
        }
    }
}