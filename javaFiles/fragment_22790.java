class Parent {
    void doSomething() {
        System.out.println("Not doing anything");
    }

    class Child {
        void whatever() {
            doSomething(); // actually: Parent.this.doSomething()
        }
    }
}

class ParentSubclass extends Parent {
    void doSomething() {
        System.out.println("I'm just slacking.");
    }

    void whatever() {
        Child a = new Child(); // Creates an instance of Parent.Child
        a.whatever(); // will print "I'm just slacking".
    }
}