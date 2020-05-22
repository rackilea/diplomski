enum KeyType {

    //your enums ...
    private final Class val;

    //constructor ...

    //and generic(!) access to the class field:
    <T> Class<T> val() {
        return val;
    }
}