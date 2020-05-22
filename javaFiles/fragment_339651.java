private static <T extends Enum<T> & Marshallable> List<T> unsafeFooHelper(Class<? extends Marshallable> type) {
    if (type.isEnum()) {

        //no longer safe!
        @SuppressWarnings("unchecked")
        final Class<T> enumType = (Class<T>)type;

        return Arrays.asList(enumType.getEnumConstants());
    }
    return Collections.emptyList();
}

enum Enum1 implements Marshallable { ONE, TWO }

enum Enum2 implements Marshallable { A, B }

...

//caller lies about what T is:
List<Enum2> enumConstants = Main.<Enum2>unsafeFooHelper(Enum1.class);

//sometime later...
Enum2 enumConstant = enumConstants.get(0); //ClassCastException