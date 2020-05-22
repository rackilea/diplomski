final class Reflection {

    private Reflection() {
    }

    static Type getTypeParameter0(final Type type) {
        if ( !(type instanceof ParameterizedType) ) {
            return Object.class;
        }
        final ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getActualTypeArguments()[0];
    }

    static Iterable<Class<?>> subToSuperClass(final Class<?> subClass) {
        return subToSuperClass(Object.class, subClass);
    }

    static <SUP, SUB extends SUP> Iterable<Class<?>> subToSuperClass(final Class<SUP> superClass, final Class<SUB> subClass) {
        if ( !superClass.isAssignableFrom(subClass) ) {
            throw new IllegalArgumentException(superClass + " is not assignable from " + subClass);
        }
        return () -> new Iterator<Class<?>>() {
            private Class<?> current = subClass;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Class<?> next() {
                if ( current == null ) {
                    throw new NoSuchElementException();
                }
                final Class<?> result = current;
                current = result != superClass ? current.getSuperclass() : null;
                return result;
            }
        };
    }


}