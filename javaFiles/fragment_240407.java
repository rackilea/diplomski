if (null == fieldAObject) {
    LOGGER.info("if A is null case : initialise it with an instance");
    Constructor[] constructors = fieldA.getType().getDeclaredConstructors();

    for (Constructor constructor : constructors) {
        constructor.setAccessible(true);
        if (0 == constructor.getParameterCount()) {
            fieldAObject = constructor.newInstance();
            fieldA.set(objectA, fieldAObject); // <-- set the new value
            break;
        }
    }