static void inspect(Object o) {
    Type type = o.getClass();
    while (type != null) {
        System.out.print(type + " implements");
        Class<?> rawType =
                (type instanceof ParameterizedType)
                ? (Class<?>)((ParameterizedType)type).getRawType()
                : (Class<?>)type;
        Type[] interfaceTypes = rawType.getGenericInterfaces();
        if (interfaceTypes.length > 0) {
            System.out.println(":");
            for (Type interfaceType : interfaceTypes) {
                if (interfaceType instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType)interfaceType;
                    System.out.print("  " + parameterizedType.getRawType() + " with type args: ");
                    Type[] actualTypeArgs = parameterizedType.getActualTypeArguments();
                    System.out.println(Arrays.toString(actualTypeArgs));
                }
                else {
                    System.out.println("  " + interfaceType);
                }
            }
        }
        else {
            System.out.println(" nothing");
        }
        type = rawType.getGenericSuperclass();
    }
}