class Parent {
    public void doSomething() {
        System.out.println("I am the Parent, and I do as I like");
    }
}

class ChildA extends Parent {
    public void doSomething() {
        System.out.println("I am a child named A, but I have my own ways, different from Parent");
    }
}

class ChildB extends Parent {
    public void doSomething() {
        System.out.println("I am a child named B, but I have my own ways, different from my Parent and my siblings");
    }
}

public class Polymorphism101 {

    public static void main(String[] args) {

        Parent p = new Parent();
        p.doSomething();

        p = new ChildA();
        p.doSomething();

        p = new ChildB();
        p.doSomething();

    }

}