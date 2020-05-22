private static final Set<Method> OBJECT_METHODS = ImmutableSet.copyOf(Object.class.getMethods());
private static boolean isObjectMethod(Method m){
    return OBJECT_METHODS.stream()
                         .anyMatch(om -> m.getName().equals(om.getName()) &&
                                         m.getReturnType().equals(om.getReturnType()) &&
                                         Arrays.equals(m.getParameterTypes(),
                                                       om.getParameterTypes()));
}