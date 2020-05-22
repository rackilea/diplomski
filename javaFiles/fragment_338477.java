import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FieldRuntimeAnnotationsTest {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface TestAnnotation {}

    public static class TestEntity {
        private String test;
    }

    @Test
    public void testPutAnnotationToField() throws NoSuchFieldException {
        // Confirm class does not have annotation
        TestAnnotation annotation = TestEntity.class.getDeclaredField("test").getAnnotation(TestAnnotation.class);
        Assert.assertNull(annotation);

        // This field is a copy of the internal one
        Field f = TestEntity.class.getDeclaredField("test");
        f.setAccessible(true);

        FieldRuntimeAnnotations.putAnnotationToField(f, TestAnnotation.class, new HashMap<>());

        // Make sure field annotation gets set
        Assert.assertNotNull(f.getAnnotation(TestAnnotation.class));

        // Make sure the class that contains that field is not updated -- THE FIELD IS A COPY
        Assert.assertNull(TestEntity.class.getDeclaredField("test").getAnnotation(TestAnnotation.class));

        // Repeat the process with the internal field
        Field f2 = getDeclaredField(TestEntity.class, "test");
        f2.setAccessible(true);

        FieldRuntimeAnnotations.putAnnotationToField(f2, TestAnnotation.class, new HashMap<>());

        // Make sure field annotation gets set
        Assert.assertNotNull(f2.getAnnotation(TestAnnotation.class));

        // Make sure the class that contains that field is also updated -- THE FIELD IS THE ORIGINAL ONE
        Assert.assertNotNull(TestEntity.class.getDeclaredField("test").getAnnotation(TestAnnotation.class));
    }

    public Field getDeclaredField(Class<?> clazz, String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        Field[] fields = getDeclaredFields(clazz);
        Field field = null;
        for (Field f : fields) {
            if (name.equals(f.getName())) {
                field = f;
            }
        }
        return field;
    }

    public Field[] getDeclaredFields(Class<?> clazz) {
        if (clazz == null) {
            return new Field[0];
        }
        Method privateGetDeclaredFieldsMethod = null;
        Object value = null;
        try {
            privateGetDeclaredFieldsMethod = Class.class.getDeclaredMethod("privateGetDeclaredFields", boolean.class);
            privateGetDeclaredFieldsMethod.setAccessible(true);
            value = privateGetDeclaredFieldsMethod.invoke(clazz, Boolean.FALSE);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Assert.fail("Error for " + clazz + ", exception=" + e.getMessage());
    }
        Field[] fields = value == null ? new Field[0] : (Field[])value;
        return fields;
    }
}