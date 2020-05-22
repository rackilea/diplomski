//File TopClass.java
class TopClass {
    class InnerClass {
    }
    static class StaticNestedClass {
    }
    interface Fooable {
    }   
    public void foo() {
        new Fooable(){}; //anonymous class
        class LocalClass { 
        }
    }
    public static void main(String... args) {
        new TopClass();
    }
}