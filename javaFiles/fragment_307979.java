public interface SomeInterface<T> {
}

public class SomeImplementation implements SomeInterface<String> {

    public Class getGenericInterfaceType(){
        Class clazz = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[0];
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        Class<?> typeArgument = (Class<?>) typeArguments[0];
        return typeArgument;
    }
}

public static void main(String[] args) {
    SomeImplementation someImplementation = new SomeImplementation();
    System.out.println(someImplementation.getGenericInterfaceType());
}