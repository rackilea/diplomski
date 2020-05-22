public class EvilBar implements Bar<SomeSpecificBar> {
    // The compiler's perfectly OK with this
    @Override
    public List<SomeSpecificBar> getFoo() {
        // ...
    }
}