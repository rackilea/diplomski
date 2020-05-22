public class FooOperation {
    private final String label;
    private final String internalCode;
    public FooOperation(String label, String internalCode) {
        this.label = label;
        this.internalCode = internalCode;
    }
    public String toString() { return label; } // human-readable, displayed in CB
    public String getCode() { return internalCode; } // ugly but true
}