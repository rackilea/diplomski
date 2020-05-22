void printMethods(final Object input) {
    for (final Field f : input.getClass().getDeclaredFields()) {
        f.setAccessible(true);
        if (Collection.class.isAssignableFrom(f.getType())) {
            final Collection<?> c = (Collection<?>) f.get(input);
            for (final Object obj : c) {
                printMethods(obj);
            }
        } else {
            System.out.println(f.get(input));
        }
    }
}