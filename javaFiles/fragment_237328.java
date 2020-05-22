class A {

    void recursive(int i) { // <-- 3. this gets called
        System.out.println("A.recursive(" + i + ")");
        if (i > 0) {
            recursive(i - 1); // <-- 4. this calls the overriden "recursive" method in class B, going back to 1.
        }
    }

}

class B extends A {

    void recursive(int i) { // <-- 1. this gets called
        System.out.println("B.recursive(" + i + ")");
        super.recursive(i + 1); // <-- 2. this calls the "recursive" method of the parent class
    }

}