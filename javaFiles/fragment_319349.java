public class BetterThing implements IBetterObject {
    Thing delegate;

    public BetterThing(Thing t) {
        this.delegate = t;
    }

    // Thing methods (delegate methods)
    String thingMethodOne() {
        return delegate.thingMethodOne();
    }

    // BetterThing methods
}