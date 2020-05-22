public static void main(String[] args) {
    Class<?> clazz = Integer.class;
    Set<Class<?>> result = dosomething(clazz);
}

public static <T> Set<Class<?>> dosomething(Class<T> clazz){
    return new HashSet<Class<?>>();
}