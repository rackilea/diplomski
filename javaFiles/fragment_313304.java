public class Test {
    public static void main(String[] args) {
        showMethods("hello");
    }

    private static void showMethods(Object target) {
        Class<?> clazz = target.getClass();

        for (Method method : clazz.getMethods()) {
            System.out.println(method.getName());
        }
    }
}