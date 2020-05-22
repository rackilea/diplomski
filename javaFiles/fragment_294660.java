public static void main(String[] args) {

    C<A> t = new D<A>();
}

static class D<T extends B<?>> implements C<T> {
    @Override
    public void ok(T b) {
        System.out.println(b.getId());
    }
}

interface C<T extends B<?>> {
    void ok(T b);
}

static class A extends B<String> {
}

static class B<T> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

}