public class PersonKeyWrapper {

    public static class PersonKey implements Key<PersonKey> {
        private PersonKey() {}
    }

    public static class PersonTypedKey<T> extends PersonKey implements TypedKey<T, PersonTypedKey<T>> {

    }

}

public class HouseKeyWrapper {

    public static class HouseKey implements Key<HouseKey> {
        private HouseKey() {}
    }

    public static class HouseTypedKey<T> extends HouseKey implements TypedKey<T, HouseTypedKey<T>> {

    }

}