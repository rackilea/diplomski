class Parent {
    class Child {
    }
}

class ParentSubclass extends Parent {
    void whatever() {
        new Child(); // Creates an instance of Parent.Child
    }
}