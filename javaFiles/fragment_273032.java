public static int compute(int value1, String operator, int value2) {
    if ("+".equals(operator)) {
        return value1 + value2;
    } else if ("-".equals(operator)) {
        return value1 - value2;
    } else if ("*".equals(operator)) {
        return value1 * value2;
    } else if ("/".equals(operator)) {
        if (value2 != 0) {
            return value1 / value2;
        }
        throw new IllegalArgumentException("Division By 0");
    }
    throw new IllegalArgumentException(String.format("Unknown operator (%s)",
            operator));
}