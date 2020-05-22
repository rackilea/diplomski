public class Foo {
    public void bar() {
        class InnerA {
            public void hello() {
                System.out.println("Hello from InnerA");
            }
            public String getName() {
                return "InnerA";
            }
        }

        class InnerB {
            private InnerA aInB = new InnerA();
            public void hello() {
                System.out.println("Hello from InnerB");
                System.out.println("In InnerB, got name of InnerA : " + aInB.getName());
            }
        }

        InnerA a = new InnerA();
        InnerB b = new InnerB();

        a.hello();
        b.hello();
    }

    public static void main(String[] args) {
        new Foo().bar();
    }
}