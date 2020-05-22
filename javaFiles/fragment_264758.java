class C<T> {
    void m(T arg) {
        System.out.println("Method [m] of class [C] called");
    }
}

class D extends C<Class<String>> implements I {
    @Override
    public void m(Class arg) {
        System.out.println("Method [m] of class [D] called");
    }
}

class DD extends C<Collection<String>> implements I {

    @Override
    public void m(Class arg) {
        System.out.println("Method [m] of class [DD] called");
    }
}