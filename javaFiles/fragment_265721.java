//avoiding exception handling, leave that up to you
static <T> T make(Class<T> clazz) {
    return clazz.newInstance();
}
//...
A a = make(A.class);