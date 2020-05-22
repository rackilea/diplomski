public <T> T create(Class<T> clazz) {
    try {
        //T must have a no arg constructor for this to work 
        return clazz.newInstance(); 
    } catch (InstantiationException e) {
        throw new IllegalStateException(e);
    } catch (IllegalAccessException e) {
        throw new IllegalStateException(e);
}