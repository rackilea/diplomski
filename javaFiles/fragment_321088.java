static String toString(Object value) {
    if (value instanceof String) {
        return (String) value;
    } else if (value != null) {
        return String.valueOf(value);
    }
    return null;
}