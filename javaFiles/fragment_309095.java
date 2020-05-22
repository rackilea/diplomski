abstract class Parent {
    String name;
    int id;
    public Parent(String n, int i) { name = n; id = i; }
}

class Child extends Parent {
    float foo;
    public Child(String n, int i, float f) {
        super(n,i);
        foo = f;
    }
}

// later
Parent p = new Parent("bob",12); // error
Child c = new Child("bob",12); // fine!