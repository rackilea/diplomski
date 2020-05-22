Element findElementReflectively(Driver driver, String elementType, String thingToSearchFor) {

    try {
        Method m = By.class.getMethod(elementType, String.class);
        if(!Modifier.isStatic(m.getModifiers())) {
            throw new NoSuchMethodException("'By' method is not static.");
        }

        return driver.findElement(m.invoke(null, thingToSearchFor));
    } catch (IllegalAccessException | NoSuchMethodException e) {
        throw new IllegalArgumentException("Unknown element type: " + elementType, e);
    } catch (InvocationTargetException e) {
        throw new RuntimeException("Failed to find requested element.", e.getCause());
    }

}