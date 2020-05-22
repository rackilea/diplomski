public class MyClass extends ClassWithNoDefaultConstructor
    public MyClass() {
        super(); //this call will be added by the compiler if you don't have any super call here
        // if the super class has no default constructor the above line will not compile
        // and removing it won't help either because the compiler will add that call
    }
}