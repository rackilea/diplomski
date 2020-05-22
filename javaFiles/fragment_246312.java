public class Example {
    private int a;

    public static final void main(String[] args) {
        new Example().go();;
    }

    Example() {
        this.a = 42;
    }

    void go() {
        System.out.println(a);      // 42, `a` is resolved to the instance field
        int a = 67;
        System.out.println(a);      // 67, `a` is resolved to the local because it
                                    // is "closer" to this code
        System.out.println(this.a); // 42, because we qualified it
    }
}