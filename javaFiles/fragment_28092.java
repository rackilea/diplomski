class A {
    STATIC interface B {
        PUBLIC STATIC class C { //It's a static class - that's why static members are legal (like a toplevel class but nested)
            static int d; //Static variable
            static {} //Static initializer

        }
    }
}