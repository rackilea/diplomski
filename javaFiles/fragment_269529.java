class Parent {
    public void init() {
        System.out.println("From the parent class");
    }
}

class Child extends Parent {
    @Override
    public void init() {
        System.out.println("From the child class");
    }
}