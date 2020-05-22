interface A {
    int getNumberOfLives();
}

interface B extends A {
    boolean isOrange();
}

class A_Impl implements A {
    int getNumberOfLives() {return 9;}
}

public class Main {
    public static void main(String[] args) {
        A a = getA();
        B b = (B)a;
        System.out.println(b.isOrange() ? "Is orange" : "Is not orange");
    }

    static A getA() {return new A_Impl();}
}