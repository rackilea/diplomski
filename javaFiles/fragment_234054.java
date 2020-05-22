public abstract class SelfBound<T extends SelfBound<T>> {
    protected abstract T getThis();

    public void doSomething(T instance) { }
    public final void doSomethingWithThis() { doSomething(getThis()); }
    public final void doSomethingWithThisUnsafe() { doSomething((T) this); }

    public static class A extends SelfBound<A> {
        @Override
        protected A getThis() {
            return this;
        }
    }

    public static class B extends SelfBound<A> {
        @Override
        public void doSomething(A instance) {
            super.doSomething(instance);
        }

        @Override
        protected A getThis() {
            return null;
        }
    }

    public static void main(String[] args) {
        new B().doSomethingWithThisUnsafe();
    }
}