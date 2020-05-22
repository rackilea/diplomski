public interface SomeInterface {
    void someMethod();
} 

public class Stat<E extends SomeInterface> {
    // any data
    // lalala
    public void do_smt(E any_ob) {
        // This is safe since you force E to implement SomeInterface
        any_ob.someMethod(); 
    }
}