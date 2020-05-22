public class Outer {
    private Foo foo;

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public static class Foo {
        private String bar;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

        public Foo() {
        }

        public Foo(String name, String bar) {
            this.name = name;
            this.bar = bar;
        }
    }

}