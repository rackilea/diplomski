public abstract class AbstractA {
    protected String s;
    protected int i;
    protected AbstractA() {
    }
    protected abstract static class ABuilder<T extends AbstractA, B extends ABuilder<T,B>> {
        protected T object;
        protected B thisObject;
        protected abstract T getObject(); //Each concrete implementing subclass overrides this so that T becomes an object of the concrete subclass
        protected abstract B thisObject(); //Each concrete implementing subclass builder overrides this for the same reason, but for B for the builder
        protected ABuilder() {
            object = getObject();
            thisObject = thisObject();
        }
        public B withS(String s) {
            object.s = s;
            return thisObject;
        }
        public B withI(int i) {
            object.i = i;
            return thisObject;
        }
        public T build() {
            return object;
        }
    }
}