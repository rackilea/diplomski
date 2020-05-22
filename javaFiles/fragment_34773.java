import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Class1Agent {

    private Class1 class1 = new Class1();

    public void log(Object... objects) throws IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        Method[] methods = class1.getClass().getMethods();
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (objects.length == parameterTypes.length) {
                int i = 0;
                while (i < objects.length
                        && parameterTypes[i].isInstance(objects[i])) {
                    ++i;
                }
                if (i == objects.length) {
                    method.invoke(class1, objects);
                    break;
                }
            }
        }
    }
}