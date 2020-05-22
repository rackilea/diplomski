public interface TypedValue {
    String getType();

    default boolean equals(String otherType) {
        return otherType != null && getType().equals(otherType.toUpperCase());
    }
}