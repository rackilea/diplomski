import java.lang.reflect.Method;

public class Main {

public static void main(String[] args) {
    for (Method m : Math.class.getMethods()) {
        Class<?>[] params = m.getParameterTypes();
        for (Class<?> param : params) {
            System.out.println(m.getName()+":"+param.getCanonicalName());
        }
     }
   } 
}