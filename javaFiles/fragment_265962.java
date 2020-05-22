public void check(Class<?> typeClass, Object object) {
    if(!GWT.isClient()) {
        if (!typeClass.isAssignableFrom(object.getClass()))
            throw new RuntimeException("Check doesn't pass!");
        }
    }
}