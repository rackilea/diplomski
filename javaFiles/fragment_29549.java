public class Tester {

    /*static class PersonTypedKey<T> implements TypedKey<T, PersonKey> { // no more allowed

    }

    static class HouseTypedKey<T> implements TypedKey<T, HouseKey> { // no more allowed

    }*/

    public static void main(String[] args) {
        Map<PersonKey> personMap = new Map<>();
        Map<HouseKey> houseMap = new Map<>();
        PersonTypedKey<String> name = new PersonTypedKey<>();
        PersonTypedKey<Integer> age = new PersonTypedKey<>();
        HouseTypedKey<String> houseName = new HouseTypedKey<>();
        String nameString = personMap.get(name);
        Integer ageInt = personMap.get(age);
        //String houseString = personMap.get(houseName); // wrong type
        //ageInt = personMap.get(name); wrong type

        whatMayBeWrongWithThis();
    }

    /*static class OtherPersonTypedKey<T> implements TypedKey<T, PersonKey> { no more allowed

    }*/

    static class ExtendedPersonTypedKey<T> extends PersonTypedKey<T> { // allowed, you can declare PersonTypedKey final if you don't wont't to allow this

    }

    static class OtherPersonTypedKey<T> implements TypedKey<T, PersonTypedKey<T>> {

    }

    public static void whatMayBeWrongWithThis() {
        Map<PersonKey> map = new Map<>();
        String val1 = map.get(new OtherPersonTypedKey<String>());
        String val2 = map.get(new ExtendedPersonTypedKey<String>());
        /*
         * OtherPersonTypedKey can not be disallowed with this declaration of PersonTypedKey
         */
    }
}