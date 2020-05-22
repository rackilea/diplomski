private Object getObject(String objectName){
    try
    {
        Field field = Urls.class.getField(objectName);
        Object o = field.get(null); // null works as well.
        return o;
    }
    catch (NoSuchFieldException e)
    { e.printStackTrace(); }
    catch (IllegalAccessException e)
    { e.printStackTrace(); }
}

private String[] getStringArray(String arrayName)
{
    return (String[]) getObject(arrayName);
}