public class EnumTest {
    public enum Foo {
        A {

            @Override
            public Bar getBar() {
                return Bar.Alpha;
            }
        },
        B {

            @Override
            public Bar getBar() {
                return Bar.Delta;
            }
        },
        C {

            @Override
            public Bar getBar() {
                return Bar.Alpha;
            }
        },

        ;

        public abstract Bar getBar();
    }

    public enum Bar {
        Alpha {

            @Override
            public Foo getFoo() {
                return Foo.A;
            }
        },
        Beta {

            @Override
            public Foo getFoo() {
                return Foo.C;
            }
        },
        Delta {

            @Override
            public Foo getFoo() {
                return Foo.C;
            }
        },

        ;

        public abstract Foo getFoo();
    }

    public static void main(String[] args) {
        for (Foo f : Foo.values()) {
            System.out.println(f + " bar " + f.getBar());
        }
        for (Bar b : Bar.values()) {
            System.out.println(b + " foo " + b.getFoo());
        }
    }
}