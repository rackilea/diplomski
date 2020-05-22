public class Main {
    static class Child extends Parent{
        class DeeplyNested {
            public void method() {
                Child.super.overriden();
            }
        }

        public void overriden() {
            System.out.println("child");
        }
    }
    static class Parent {
        public void overriden() {
            System.out.println("parent");
        }
    }
    public static void main(String args[]) {
        Child child = new Child();
        DeeplyNested deep = child.new DeeplyNested();
        deep.method();
    }
}