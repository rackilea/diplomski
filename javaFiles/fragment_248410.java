Object parameterClassInstance = null;
try {
    Constructor<?> defaultConstructor = type.getDeclaredConstructor();
    defaultConstructor.setAccessible(true);
    parameterClassInstance = defaultConstructor.newInstance();
} catch (InstantiationException ex) {
    LOGGER.log(Level.FINE, null, ex);
} catch (IllegalAccessException ex) {
    LOGGER.log(Level.FINE, null, ex);
} catch (IllegalArgumentException ex) {
    LOGGER.log(Level.FINE, null, ex);
} catch (InvocationTargetException ex) {
    LOGGER.log(Level.FINE, null, ex);
} catch (SecurityException ex) {
    LOGGER.log(Level.FINE, null, ex);
} catch (NoSuchMethodException ex) {
    //getting here for Boolean/String and some other primitive data type
    LOGGER.log(Level.FINE, null, ex);
}

if (parameterClassInstance==null) {
    return null;
}