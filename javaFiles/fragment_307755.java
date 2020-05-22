import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Foo<T> {
    T field;

    void bar(List<T> list) {
        T obj = list.get(0);
        T zip = field;
    }

    public static void main(String[] args) throws ReflectiveOperationException {
        Field field = Foo.class.getDeclaredField("field");
        System.out.println("Field:"
                + "\n - " + field.getType()
                + "\n - " + field.getGenericType()
                + "\n - " + field.getAnnotatedType()
        );
        Method method = Foo.class.getDeclaredMethod("bar", List.class);
        System.out.println("Method:"
                + "\n - " + Arrays.toString(method.getParameterTypes())
                + "\n - " + Arrays.toString(method.getGenericParameterTypes())
        );
        Foo<Integer> foo = new Foo<>();
        // foo.field = "hi"; <- Compile error, incompatible types
        field.set(foo, "hi"); //
        // Integer value = foo.field; <- Accepted by compiler, fails at runtime with ClassCastException
        Object value = foo.field; // OK
        System.out.println("Value of field: " + value + " (class: " + value.getClass() + ")");
    }
}