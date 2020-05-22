public class Sample {

    public static void main(String args[]) throws Exception {
        ParameterizedType type = (ParameterizedType) IntegerContainer.class.getGenericInterfaces()[0];
        Class<?> rawType = (Class<?>) type.getRawType();
        TypeVariable<? extends Class<?>>[] typeVariables = rawType.getTypeParameters();
        System.out.println(Arrays.toString(type.getActualTypeArguments()));
        System.out.println(Arrays.toString(typeVariables));
    }
}

interface Container<E> {
}

interface IntegerContainer extends Container<Integer> {
}