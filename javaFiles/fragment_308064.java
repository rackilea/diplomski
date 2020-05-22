public class MyClassProducer {
    @Produces
    <GENERIC_TYPE> MyClass<GENERIC_TYPE> createMyClass(InjectionPoint injectionPoint){
        final ParameterizedType parameterizedType = (ParameterizedType) injectionPoint.getType();
        final Class<GENERIC_TYPE> genericTypeClass = 
            (Class<GENERIC_TYPE>) parameterizedType.getActualTypeArguments()[0];
        return new MyClass(genericTypeClass);
    }
}