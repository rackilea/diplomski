private static HashMap<String, Object> getMemberFields(Object obj) throws IllegalAccessException,
        NoSuchFieldException
{
     HashMap<String, Object> fieldValues = new HashMap<String, Object>();
            Class<?> objClass = obj.getClass();

    Field[] fields = objClass.getDeclaredFields();
    for(Field field : fields)
    {
        field.setAccessible(true);
        fieldValues.put(field.getName(), field.get(obj));
        if (!field.getType().isPrimitive() && !field.getType().getName().contains("java.lang"))
        {
            getMemberFields(field.get(obj));
        }
    }
    return fieldValues;
}