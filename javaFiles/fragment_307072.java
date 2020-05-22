public class YourClass extends Class1 {

    private final Class2 class2Impl = new Class2() {
    // Class2 "view" of this class, this inner class
    // has access to all fields/methods of YourClass
    };

    public Class2 asClass2() { return class2Impl; }

    }