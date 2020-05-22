public static Child newInstance(Integer... numbers) {
    return new Child(numbers);
}

@SafeVarargs
public static <T> T[] array(T... items) {
    return items;
}