class Example {

    int a = 42;

    // Instance initializer block:
    {
        this.a = 67;
    }

    Example() {
        System.out.println(this.a);
    }
}