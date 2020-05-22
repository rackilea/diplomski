public static void main(String[] args) {
    Class<Integer> clazz = Integer.class;
    Set<Class<? extends Integer>> result = dosomething(clazz);
}

public static <T> Set<Class<? extends T>> dosomething(Class<T> clazz){
    return new HashSet<Class<? extends T>>();
}