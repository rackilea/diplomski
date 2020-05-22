class A {}

class B extends A {}

abstract class Parent {
    abstract Set<? extends A> getSet();
}

class Child extends Parent {
    Set<? extends B> getSet() {
        return new HashSet<B>();
    }
}