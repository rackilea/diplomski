private static <T extends Enum<T> & Marshallable> void fooHelper(Class<? extends Marshallable> type) {
    if (type.isEnum()) {

        //This is safe because of the isEnum check, and we don't return any
        //type with T (important because the caller can specify what T is).
        @SuppressWarnings("unchecked")
        final Class<T> enumType = (Class<T>)type;

        final List<T> enumConstants = Arrays.asList(enumType.getEnumConstants());
        foo(enumConstants);
    }
}