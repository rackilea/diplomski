public static Object getFieldValue(Object target, String fieldName){
    // get field from class
    Field field = target.getClass().getDeclaredField(fieldName);

    // set accessability to "public"
    field.setAccessible(true);
    try{
        // get value
        return field.get(target);
    } catch(IllegalAccessException e){
        // or throw error
        throw new IllegalStateException(e);
    }
}