class AnnotationProcessor implements ParameterResolver{
    @Override
    public boolean supportsParameter(
        ParameterContext parameterContext, 
        ExtensionContext extensionContext
    ) {
        Parameter parameter = parameterContext.getParameter();

        Type type = parameter.getParameterizedType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (!parameterizedType.getRawType().equals(List.class))
                return false;
            Type firstParameterType = parameterizedType.getActualTypeArguments()[0];
            return firstParameterType.equals(Person.class);
        }

        return false;
    }

    @Override
    public Object resolveParameter(
        ParameterContext parameterContext,
        ExtensionContext extensionContext
    ) {
        return Arrays.asList(new Person(), new Person());
    }
}