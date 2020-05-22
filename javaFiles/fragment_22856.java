package hello;

    public class Hello extends Object {

        public String sayHello2(String name) {
            String result = new String("Hello " + name);
            return result;
        }

        public Hello sayHello3(String name) {
            String result = new String("Hello " + name);
            return new Hello();
        }

    }