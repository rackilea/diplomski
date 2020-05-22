public class SomeSpecificBar implements Bar<SomeSpecificBar> {
    // Compiler will enforce the type here
    @Override
    public List<SomeSpecificBar> getFoo() {
        // ...
    }
}