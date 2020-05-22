static interface Delegator<T> {}
static class DelegatorChain<T extends Delegator<? super T>> {}
static interface Foo {}
static class FooDelegator implements Delegator<Foo>, Foo {}

public static void main(String[] args) {
    DelegatorChain<FooDelegator> chain = new DelegatorChain<FooDelegator>();
}