import java.util.*;
import java.lang.reflect.*;

public class Test {
    public static void main(String[] args) {
        showTypeParameters(ArrayList.class);
        showTypeParameters(HashMap.class);
    }

    private static void showTypeParameters(Class<?> clazz) {
        System.out.printf("%s:%n", clazz.getName());
        for (TypeVariable typeParameter : clazz.getTypeParameters()) {
            System.out.printf("  %s%n", typeParameter.getName());
        }
    }    
}