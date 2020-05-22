private String getFieldValue(String fieldName, T object)
    {
    Field field;
    try
    {
        field = object.getClass().getDeclaredField(fieldName);
    }
    catch (NoSuchFieldException e)
    {
        logger.error(e);
        return null;// or ""
    }
    field.setAccessible(true);
    try
    {
        return (String) field.get(object));
    }
    catch (IllegalAccessException e)
    {
        logger.error(e);
        return null;// or ""
    }