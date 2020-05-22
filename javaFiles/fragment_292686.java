public final class ContractUtilities {
    public static IllegalStateException unreachable() {
        return new IllegalStateException("Code is supposed to be unreachable.");
    }
    // ...
}