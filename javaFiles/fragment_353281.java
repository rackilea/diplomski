class Parent { }
class Child extends Parent { }

class Main {
    public static void main(String... args) {
        Parent parent = new Child();
        System.out.println(parent.getClass());  // Child.class
    }
}