import java.lang.reflect.Field;
....

Foo foo = new Foo();
foo.setName("old Name");
String fieldName = "name";
Class class1 = Foo.class;

try {

    System.out.println(foo.getName());

    Field field = class1.getDeclaredField(fieldName);

    field.setAccessible(true);

    field.set(foo, "My New Name");

    System.out.println(foo.getName());

} catch (NoSuchFieldException e) {
    System.out.println("FieldNotFound: " + e);
} catch (IllegalAccessException e) {
    System.out.println("Ilegal Access: " + e);
}