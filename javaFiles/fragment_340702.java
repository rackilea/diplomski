static <E extends Enum<E>> E getNextDeclared(E e) {
    int ordinal = e.ordinal();
    for (E object : EnumSet.allOf(e.getDeclaringClass())) {
        if (object.ordinal() == ordinal + 1) {
            return object;
        }
    }
    throw new IllegalArgumentException();
}