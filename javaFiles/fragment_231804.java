class Example {

    int a = 0; // This is fine, it's an initializer on a member declaration

    int b;     // This is also fine, it's a member declaration

    b = 0;     // This is an error, it's an assignment that isn't in a method,
               // constructor, or initializer block

    {
        b = 0; // This is fine, because it's inside an *instance* initializer
               // block. These blocks are run when an instance is being
               // constructed, just before the constructor is called
    }

    static int c;

    static {
        c = 0; // This is fine, because it's inside a *static* initializer block
               // These blocks are run when the class (as a whole, not an 
               // instance) is being initialized
    }

    void method() {
        b = 0; // This is fine, because it's inside a method
    }
}