import java.lang.reflect.Field;

public class ReflectionTest {

    public static void main(final String[] args) throws Exception {
        Object obj = new Person("Person Name", 20);

        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println(f.getName() + " = " + f.get(obj));
        }
    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(final String name, final int age) {
            super();
            this.name = name;
            this.age = age;
        }

    }

}