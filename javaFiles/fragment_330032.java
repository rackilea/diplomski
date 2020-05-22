import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Test101 {

    public static void main(String[] args) {
        Map<String, String> values = new HashMap<>(3);
        values.put("EqpSk", "123");
        values.put("Capacity", "456");
        values.put("Quanity", "987");

        Test101 o = new Test101();
        for (Method m : o.getClass().getDeclaredMethods()) {
            String name = m.getName();
            if (name.startsWith("set")) {
                name = name.substring(3);
                if (values.containsKey(name)) {
                    try {
                        String value = values.get(name);
                        Class<?>[] types = m.getParameterTypes();
                        if (types[0] == String.class) {
                            m.invoke(o, value);
                        } else if (types[0] == double.class || types[0] == Double.class) {
                            m.invoke(o, Double.parseDouble(value));
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exp) {
                        exp.printStackTrace();
                    }
                }
            }
        }
    }

    public void setEqpSk(String value) {
        System.out.println("EqpSk = " + value);
    }

    public void setCapacity(double value) {
        System.out.println("Capacity = " + value);
    }

    public void setQuanity(Double value) {
        System.out.println("Quanity = " + value);
    }

}