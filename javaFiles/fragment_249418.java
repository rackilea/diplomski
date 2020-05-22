@FooAnnotation(foo = "Foo")
public class MyAnnotatedClass {
    public static void main (String[] args) {
        FooAnnotation annot = MyAnnotatedClass.class.getAnnotation(FooAnnotation.class);
        Method[] methods = FooAnnotation.class.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getName() + "() returns:\n");
            try {
                String value = (String) method.invoke(annot);
                System.out.println("\t" + value);
            } catch (Exception e) {
                System.out.println("\tERROR! " + e.getMessage());
            }
        }
    }
}