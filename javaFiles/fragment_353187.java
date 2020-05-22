class A
{
    static int a;

    private int b;

    // static/class initialization:
    static
    {
        // initialize class members
        a = 5;
    }

    // instance initialization:
    {
        // initialize instance members
        b = 5;
    }
}