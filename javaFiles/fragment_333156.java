public static void checkClass(Class<?> clazz) {
    boolean used = false;
    for( Method method : clazz.getDeclaredMethods() ) {
        if( method.getAnnotation(Foo.class) != null ) {
            if( used ) { 
                throw new IllegalFooUseException(); 
            }
            else { used = true; }
        }
    }
}