void handleScriptingException(ScriptingException se)
{ 
    final Throwable t1 = se.getCause();
    String lineSource = null;
    String filename = null;
    Integer lineNumber = null;

    if (hasGetterMethod(t1, "sourceName"))
    {
        lineNumber = getProperty(t1, "lineNumber", Integer.class);
        filename = getProperty(t1, "sourceName", String.class);
        lineSource = getProperty(t1, "lineSource", String.class);
    }
    else
    {
        filename = se.getFileName();
        lineNumber = se.getLineNumber();
    }
    /* do something with this info */
}

static private Method getGetterMethod(Object object, String propertyName)
{
    String methodName = "get"+getBeanSuffix(propertyName);
    try {
        Class<?> cl = object.getClass();
        return cl.getMethod(methodName);
    }
    catch (NoSuchMethodException e) { 
        return null;
        /* gulp */ 
    }
}
static private String getBeanSuffix(String propertyName) {
    return propertyName.substring(0,1).toUpperCase()
       +propertyName.substring(1);  
}   
static private boolean hasGetterMethod(Object object, String propertyName) 
{
    return getGetterMethod(object, propertyName) != null;
}
static private <T> T getProperty(Object object, String propertyName, 
        Class<T> cl) {
    try {
        Object result = getGetterMethod(object, propertyName).invoke(object);
        return cl.cast(result);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}