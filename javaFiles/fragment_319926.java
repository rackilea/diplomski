import com.twitter.chill.MeatLocker;

public class MyClass {

    final MeatLocker<A> _field1; // Non-serializable object

    public void doSomething() {
        myJavaDStream...
                     .map(t -> {
                         // call _field1.get() instead of _field1 to unwrap the value
                     })
    }
}