public static <T> T copy(T source, T target) throws IllegalArgumentException, IllegalAccessException {
    for ( Field f : target.getClass().getDeclaredFields() ) {
        f.setAccessible( true );
        Object o = f.get( source );
        f.set( target, o);
    }
    return target;
}