public class Main {
    public static void main(String... args) {
        int fooVersion = Integer.parseInt(args[0]);

        SuperFoo superFoo;
        switch(int) {
            case 1: {
                superFoo = new Foo1();
                break;
            }
            case 2: {
                superFoo = new Foo2();
                break;
            }
            case 3: {
                superFoo = new Foo3();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }

        superFoo.bar();
    }
}