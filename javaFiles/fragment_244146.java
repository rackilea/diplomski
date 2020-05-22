public class Scratchpad {
    public static void main(String[] args) {
        new Sub().doSomething();
    }
}

class Super {
    public void doSomething() {
        System.out.println(computeOutput());
    }

    private String computeOutput() {
        return "Foo";
    }
}

class Sub extends Super {
    public String computeOutput() {
        return "Bar";
    }
}