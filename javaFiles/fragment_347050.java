class Foo
{
    public static void f()
    {
        instanceMethod(); // Not OK - no instance provided.
        this.instanceMethod(); // Not OK -  no "this" in static methods.
        new Foo().instanceMethod();  // OK because you provide an instance
    }

    public void instanceMethod() {}
}