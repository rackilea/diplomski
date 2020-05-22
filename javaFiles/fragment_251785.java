public static <T extends Enum<T> & Parent> T fromInt(Class<T> enumClass) {
    return Arrays.stream(enumClass.getEnumConstants())
                 .filter(ev -> ev.someMethod() == 1)
                 .findFirst()
                 .get();
}