public abstract class A {

    public static void doStuff() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        System.out.println("starting main in A");
        doStuff();
    }
}

class B extends A {
    public static void doStuff() {
        System.out.println("B");
    }
}