public class StackOverflow {
    public static void main(String[] args) throws Exception {
        Method method = StackOverflow.class.getDeclaredMethod("method", List.class);
        Type[] parameterTypes = method.getGenericParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println(parameterType.getClass());
            System.out.println(parameterType);
            ParameterizedType parameterizedType = (ParameterizedType) parameterType;
            System.out
                    .println(parameterizedType.getRawType().getTypeName() + "<" + parameterizedType.getActualTypeArguments()[0].getTypeName() + ">");
        }
    }

    public String method(List<StackOverflow> parameter) {
        return "example";

    }
}