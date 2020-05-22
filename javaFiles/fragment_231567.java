import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;

public class Erasure<T>
{
    public static void main(String...strings) {
      Class<?> foo = new Erasure<HashMap<Integer, String>>() {}.getClass();
      ParameterizedType t = (ParameterizedType) foo.getGenericSuperclass();
      System.out.println(t.getOwnerType());
      System.out.println(t.getRawType());
      System.out.println(Arrays.toString(t.getActualTypeArguments()));
    }
}