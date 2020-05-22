package test;

public class Tester {

public test.Tester.Hello getHelloObject() {
    return new Hello();
}

private class Hello {

    void sayHello() {
        System.out.println("hello");
    }
}

public static void main(String[] args) {
    Tester dude = new Tester();
    Hello man = dude.getHelloObject();
    man.sayHello();
}