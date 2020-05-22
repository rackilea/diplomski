public class Demo {

    List<String> list = new ArrayList<>();
    Collection<String> coll = new ArrayList<>();

    public static void main(String args[]){

        Class<Demo> clazz = Demo.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {

            Type type = field.getGenericType();

            if (type instanceof ParameterizedType) {

                ParameterizedType pType = (ParameterizedType)type;
                Type[] arr = pType.getActualTypeArguments();

                for (Type tp: arr) {
                    Class<?> clzz = (Class<?>)tp;
                    System.out.println(clzz.getName());
                }
            }
        }
    }
}