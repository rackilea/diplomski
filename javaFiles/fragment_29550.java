public class PersonKeyWrapper {

    public static class PersonKey implements Key<PersonKey> {
        private PersonKey() {
        }
    }

    private static class PersonTypedKey<T> extends PersonKey implements TypedKey<T, PersonTypedKey<T>> {

    }

    public static <T> TypedKey<T, ? extends PersonKey> get() {
        return new PersonTypedKey<T>();
    }

}

public class HouseKeyWrapper {

    public static class HouseKey implements Key<HouseKey> {
        private HouseKey() {}
    }

    private static class HouseTypedKey<T> extends HouseKey implements TypedKey<T, HouseTypedKey<T>> {

    }

    public static <T> TypedKey<T, ? extends HouseKey> get() {
        return new HouseTypedKey<T>();
    }

}