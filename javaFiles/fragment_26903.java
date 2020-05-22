public class StringOrDouble {
    private String internalString;
    private Double internalDouble;

    public StringOrDouble(String input) {
        internalString = input;
    }

    public StringOrDouble(Double input) {
        internalDouble = input;
    }

    public boolean hasString() {
        return internalString != null;
    }

    public boolean hasDouble() {
        return internalDouble != null;
    }

    public String getString() {
        return internalString;
    }

    public Double getDouble() {
        return internalDouble;
    }
}