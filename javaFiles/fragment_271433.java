public List<Method> getMethodsIgnoreCase
    (Class<?> clazz, String methodName, Class<?> paramType) {

    return Arrays.stream(clazz.getMethods())
                 .filter(m -> m.getName().equalsIgnoreCase(methodName))
                 .filter(m -> m.getParameterTypes().length ==  1)
                 .filter(m -> m.getParameterTypes()[0].equals(paramType))
                 .collect(Collectors.toList());
}