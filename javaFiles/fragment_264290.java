public static void main(String[] args) {
    inspect(Example.class);
}

public static <T> void inspect(Class<T> klazz) {
    Field[] fields = klazz.getDeclaredFields();
    for (Field field : fields) {
        if (field.getName().startsWith("top")) {
            // get ONLY fields starting with top
            System.out.printf("%s %s %s%n",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()
            );
        }
    }
}