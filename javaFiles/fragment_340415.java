public class Test {
    public static class Foo implements Serializable {
        private A a;

        public Foo(A a) {
            this.a = a;
        }

        //More code
    }

    public static class A implements Serializable {
        public Collection<B> vector = new Vector<>();

        //More code
    }

    public static class B implements Serializable {
        private transient A parent;
        private String name;

        public B(A a, String name) {
            this.parent = a;
            this.name = name;
        }

        //More code
    }

    public static void main(String[] args) {

        A a = new A();
        a.vector.add(new B(a, "name"));

        Foo foo = new Foo(a);

        Bytes bytes = Wires.acquireBytes();
        final ValueOut out = WireType.JSON.apply(bytes).getValueOut();
        out.marshallable(foo);

        System.err.println(bytes.toString());
    }
}