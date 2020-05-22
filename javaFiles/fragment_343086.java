public static void main(String[] args) {
    if (getSomeThing(7, Boolean.class, emptyMap())) {
        System.out.println("It works!");
    }
}

public static <T> T getSomeThing(final int id,
                                 final Class<T> clazz,
                                 final Map<Integer, String> someThings) {
    ...
}