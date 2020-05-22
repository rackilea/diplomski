// This is an anonymous class
Expectations expectations = new Expectations() {
    // Class body here
};

class Foo {

    // This is an instance initializer block in a normal class
    {
        System.out.println("You'll see this via either constructor");
    }

    Foo(int x) {}

    Foo(String y) {}
}