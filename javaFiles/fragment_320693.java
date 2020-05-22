public class Singleton {
    private static final Singleton instance = null;

    // make the class private to prevent direct instantiation.
    // this forces clients to call newInstance(), which will
    // ensure the class' Singleton property.
    private Singleton() { } 

    public static Singleton newInstance() {
        // if instance is null, then instantiate the object by calling
        // the default constructor (this is ok since we are calling it from 
        // within the class)
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}