class BChange extends AChange<B> {
    public String street() {
        return instance.getStreet();
    }
}

class CChange extends AChange<C> {
    public int number() {
        return instance.getNumber();
    }
}