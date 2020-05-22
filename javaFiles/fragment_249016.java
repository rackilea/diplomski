interface A<T extends A<T>> {
    A sum (T another);
}

class AClass implements A<AClass> {
    private int internalStuff;

    public A sum(AClass another) {
        // ....
    }
}