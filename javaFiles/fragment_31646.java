public abstract class Specification {

    Specification() {
        // Package private, thus not accessible to the client
        // No subclassing possible
    }

    Stuff getInternalValue1() {
        // Package private, thus not accessible to the client
        // Client cannot call this
    }
}