public abstract class NumberSet {

    // Constructor is package private, so no new classes can be derived from
    // this guy outside of its package.
    NumberSet() {
    }
}

public class Factories {

    public NumberSet range(int start, int length) {
        return new RangeNumberSet(start, length);
    }

    // ...
}

class RangeNumberSet extends NumberSet {
   // ... must be defined in the same package as NumberSet
   // Is "invisible" to client code
}