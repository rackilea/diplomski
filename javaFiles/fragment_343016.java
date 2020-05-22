import java.lang.reflect.Array;
...

public static <B> Object defaultValue(Class<B> clazz) {
    return Array.get(Array.newInstance(clazz, 1),0);
}