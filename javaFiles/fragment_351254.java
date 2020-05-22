class MyClass {

    public static void foo(List<String> s) {
        // ..
    }

    public static void main(String[] args) throws Exception {
        Method method = MyClass.class.getMethod("foo", List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for (Type parameterArgType : parameterArgTypes) {
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = "
                            + parameterArgClass);
                }
            }
        }
    }
}