abstract class A {
    public final void func() { // Some service offered by this class.
        B b = ...;
        C c = onFunc(b);
    }

    abstract protected C onFunc(B b); // Some requirement to implement.
}