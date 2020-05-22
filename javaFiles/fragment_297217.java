class Main {
    enum SomePkgEnum { A, B, C };
    public enum SomePubEnum { A, B, C };
    private enum SomePrivEnum { A, B, C };
    protected enum SomeProtEnum { A, B, C };
}

// Top-level enum: Only public (or package level) access allowed.
public enum SomeOtherEnum { A, B, C };