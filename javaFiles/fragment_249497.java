class C<X extends B> {

    public A<X> getA() { ... }

    public X getGenericXOfA() {
        return getA().getX();
    }

}