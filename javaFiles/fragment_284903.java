class MyClass {
}

class ParentClass {
    protected void parentMethod() {
    }
}

class ChildClass extends ParentClass {
    private void myMethod() {
        MyClass mine = new MyClass() {
            public void anotherMethod() {
                parentMethod(); // this works
            }
        };
    }
}