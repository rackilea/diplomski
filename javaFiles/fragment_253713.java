public Object coerceArgument(Object argument) {
    if (argument instanceof BigDecimal) {
        return argument;
    } else if (argument instanceof Long) {
        return new BigDecimal((Long) argument);
    } else if (argument instanceof BigInteger) {
        return new BigDecimal((BigInteger) argument);
    }

    if (argument instanceof Number) {
        return new BigDecimal(((Number) argument).doubleValue());
    }
    return argument;
}