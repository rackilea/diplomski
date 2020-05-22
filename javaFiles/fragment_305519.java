public <T> T createObject(Class<T> type) throws IllegalArgumentException {   
    try {
        return type.getConstructor().newInstance();      
    } catch (NoSuchMethodException | InstantiationException
            | IllegalAccessException | InvocationTargetException e) {
        throw new IllegalArgumentException(e);
    }
}