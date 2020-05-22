class Ideone {
    public static void main(String[] args) throws java.lang.Exception {
        A<ConcreteErrorHandler> a = new A<ConcreteErrorHandler>(new ConcreteErrorHandler());
        a.m();
    }

    public static class AbstractErrorHandler {
        public void handle() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public static class ConcreteErrorHandler extends AbstractErrorHandler {
        public void handle() {
            System.out.println("Concrete handler");
        }
    }

    public static class A<T extends AbstractErrorHandler> {

        T instance;

        A(T instance) {
            this.instance = instance;
        }

        public void m() {
            instance.handle();
        }
    }
}