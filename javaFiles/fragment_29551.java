public class Tester {

    public static void main(String[] args) {
        Map<PersonKey> personMap = new Map<>();
        Map<HouseKey> houseMap = new Map<>();
        TypedKey<String, ? extends PersonKey> name = PersonKeyWrapper.get();
        TypedKey<Integer, ? extends PersonKey> age = PersonKeyWrapper.get();
        TypedKey<String, ? extends HouseKey> houseName = HouseKeyWrapper.get();
        String nameString = personMap.get(name);
        Integer ageInt = personMap.get(age);
        //String houseString = personMap.get(houseName); // wrong type
        //ageInt = personMap.get(name); wrong type
    }

    /*static class ExtendedPersonTypedKey<T> extends PersonTypedKey<T> { // no more allowed

    }

    static class OtherPersonTypedKey<T> implements TypedKey<T, PersonTypedKey<T>> { // no more allowed

    }*/
}