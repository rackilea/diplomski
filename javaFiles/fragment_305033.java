// DefaultString.java:
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultString {
    String value();
}

// DefaultInteger.java:
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultInteger {
    int value();
}

// DefaultPojo.java:
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DefaultPojo {

    public void setDefaults() {
        for (Field f : getClass().getFields()) {
            f.setAccessible(true);
            try {
                if (f.get(this) == null) {
                    f.set(this, getDefaultValueFromAnnotation(f.getAnnotations()));
                }
            } catch (IllegalAccessException e) { // shouldn't happen because I used setAccessible
            }
        }
    }

    private Object getDefaultValueFromAnnotation(Annotation[] annotations) {
        for (Annotation a : annotations) {
            if (a instanceof DefaultString)
                return ((DefaultString)a).value();
            if (a instanceof DefaultInteger)
                return ((DefaultInteger)a).value();
        }
        return null;
    }

}

// Test Pojo
public class TestPojo extends DefaultPojo {
    @DefaultString("Hello world!")
    public String stringValue;
    @DefaultInteger(42);
    public int integerValue;
}