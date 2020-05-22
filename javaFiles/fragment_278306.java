// in the core jar file
public interface Optional {
    void optionalMethod();
}

// in the optional jar file
public class OptionalImpl implements Optional {
    public void optionalMethod() {
        // implementation
    }
}