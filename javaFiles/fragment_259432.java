import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TestReflection {
    double x;
    double y;
    double width;
    double height;
    double angle;
    public TestReflection() {
    }
    public void setPartProperties(Map<String, Double> fieldValueMap) throws NoSuchFieldException, IllegalAccessException {
        Class<TestReflection> clazz = TestReflection.class;
        for(Map.Entry<String, Double> entry : fieldValueMap.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.set(this, entry.getValue());
        }
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String, Double> fieldAndValues = new HashMap<>();
        fieldAndValues.put("x", 10.0);
        fieldAndValues.put("y", 20.0);
        fieldAndValues.put("width", 30.0);
        fieldAndValues.put("height", 40.0);
        fieldAndValues.put("angle", 50.0);
        TestReflection testReflection = new TestReflection();
        testReflection.setPartProperties(fieldAndValues);
        System.out.println(testReflection);
    }

    @Override
    public String toString() {
        return "TestReflection{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", angle=" + angle +
                '}';
    }
}