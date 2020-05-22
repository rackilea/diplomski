import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public <T> void updateObjFromObj(T objToUpdate, T objToUse)
        throws IllegalAccessException {
    Class<?> clazz = objToUpdate.getClass();

    while (clazz != null) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                boolean accessible = field.isAccessible();
                field.setAccessible(true);
                if (field.get(objToUse) != null) {
                    field.set(objToUpdate, field.get(objToUse));
                }
                field.setAccessible(accessible);
            }
        }

        clazz = clazz.getSuperclass();
    }
}