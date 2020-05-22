import java.lang.reflect.Field;

public class FooBar extends AbstractFooBar{
public String foo = "Search for foo";
public String bar = "Search for bar";

public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    Field[] fields = FooBar.class.getFields();
    // Field[] fields = AbstractFooBar.class.getFields();
    for (Field field : fields) {
        System.out.println(field.get(new Object()).toString());
    }
}