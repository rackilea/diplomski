@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Set {
    int value();
}

class Injector {
    public static void inject(Object instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Set.class)) {
                Set set = field.getAnnotation(Set.class);
                field.setAccessible(true); // should work on private fields
                try {
                    field.set(instance, set.value());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Demo {
    @Set(1)
    public int var;
    public int var2;

    public void call(){
        Injector.inject(this);
        System.out.println(var);
        System.out.println(var2);
    }
}
public class AnnotationDemo {
    public static void main(String[] args) {
        new Demo().call();
    }
}