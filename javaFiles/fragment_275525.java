public class SomeClass {
    static {
      SomeFactory.registerSomeImplementation(SomeClass.class)
    }
}

Class.forName("somePackage.SomeClass") // Alternative 1 
SomeClass.class.getName();             // Alternative 2