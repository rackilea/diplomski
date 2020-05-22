public static <T1, T2> T2 getFieldValue(T1 obj, String fieldName, Class<T2> cls) {
    Field field = null;
    T2 value = null;
    try {
        field = obj.getClass().getField(fieldName);
    } catch (NoSuchFieldException e) {
    }
    if (field != null) {
        try {
            value = cls.cast(field.get(obj));  // <---  no unchecked cast!!!
        } catch (IllegalAccessException e) {
        } catch (ClassCastException e) {
        }
    }
    return value;
}