import java.lang.reflect.*;
import java.util.*;

public class Test {

    public static void main(String [] args) {
        for (Method method : Test.class.getMethods()) {
            System.out.println(method.getName());
            Type type = method.getGenericReturnType();
            System.out.println("Return type: " + type.getTypeName());
            if (type instanceof ParameterizedType)
            {
                ParameterizedType pt = (ParameterizedType) type;
                System.out.println("Parameterized: " + pt.getRawType());
                for (Type arg : pt.getActualTypeArguments())
                {
                    System.out.println("  " + arg);
                }
            }
        }
    }

    public static List<Integer> getNumbers() {
        return null;
    }

    public static List<String> getStrings() {
        return null;
    }
}