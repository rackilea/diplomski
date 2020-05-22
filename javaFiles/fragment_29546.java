public class Tester {

    static final class PersonKey implements Key<PersonKey> {
        private PersonKey() {}
    }

    static final class HouseKey implements Key<HouseKey> {
        private HouseKey() {}
    }

    static final class WrongKey implements Key<PersonKey> {
        private WrongKey() {}
    }

    static class ExtendableKey implements Key<ExtendableKey> {

    }

    static class ExtensionKey extends ExtendableKey {

    }

    static class PersonTypedKey<T> implements TypedKey<T, PersonKey> {

    }

    static class HouseTypedKey<T> implements TypedKey<T, HouseKey> {

    }

    /*static class ExtensionTypedKey<T> implements TypedKey<T, ExtensionKey> { // wrong type

    }

    static class WrongTypedKey<T> implements TypedKey<T, WrongKey> { // wrong type

    }*/

    public static void main(String[] args) {
        Map<PersonKey> personMap = new Map<>();
        Map<HouseKey> houseMap = new Map<>();
        //Map<WrongKey> wrongMap = new Map<>(); // wrong type
        //Map<ExtensionKey> extMap = new Map<>(); // wrong type
        PersonTypedKey<String> name = new PersonTypedKey<>();
        PersonTypedKey<Integer> age = new PersonTypedKey<>();
        HouseTypedKey<String> houseName = new HouseTypedKey<>();
        String nameString = personMap.get(name);
        Integer ageInt = personMap.get(age);
        //String houseString = personMap.get(houseName); // wrong type
        //ageInt = personMap.get(name); wrong type
        Map<ExtendableKey> extMap = new Map<>();

        whatMayBeWrongWithThis();
    }

    static class OtherPersonTypedKey<T> implements TypedKey<T, PersonKey> {

    }

    static class ExtendedPersonTypedKey<T> extends PersonTypedKey<T> {

    }

    public static void whatMayBeWrongWithThis() {
        Map<PersonKey> map = new Map<>();
        String val1 = map.get(new OtherPersonTypedKey<String>());
        String val2 = map.get(new ExtendedPersonTypedKey<String>());
        /*
         * TypedKey inheritance can be disallowed be declaring the class final, OtherPersonTypedKey can not be disallowed
         * with those declarations
         */
    }

    // if needed you can allow Key inheritance by declaring key, typedKey and map with extends Key<? super K>
}