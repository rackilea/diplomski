private List<Class<?>> inferGenericTypes(Method method) {
    List<Class<?>> inferredTypes = new ArrayList<Class<?>>();
    Type[] parameterTypes = method.getGenericParameterTypes();
    for (Type parameterType : parameterTypes) {
        if (parameterType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) parameterType;
            for (Type t : type.getActualTypeArguments()) {
                if (t instanceof ParameterizedType) {
                    // this the case when parameterized type looks like this: Collection<List<String>>
                    // we care only for raw type List
                    inferredTypes.add((Class<?>) ((ParameterizedType) t).getRawType());
                } else if (t instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) t;
                    if (wildcardType.getUpperBounds().length > 0) {
                        // upper bounds (? extends Number)
                        inferredTypes.add((Class<?>) wildcardType.getUpperBounds()[0]);
                    } else {
                        // lower bounds (? super Number)
                        inferredTypes.add((Class<?>) wildcardType.getLowerBounds()[0]);
                    }
                } else {
                    inferredTypes.add((Class<?>) t);
                }
            }
        }
    }
    return inferredTypes;
}