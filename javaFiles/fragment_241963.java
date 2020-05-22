public static Number random_val(Number value) {
    // ...do calculation based on whether `value` is a Float
    // or an Integer, fail if it's another kind of number (Double,
    // Byte, ...), return either a Float or an Integer
    if (value instanceof Float) {
        Float result = /*...*/;
        return result;
    }
    if (value instanceof Integer) {
        Integer result = /*...*/;
        return result;
    }
    throw new IllegalArgumentException("value must be Float or Integer");
}