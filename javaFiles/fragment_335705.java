public static int toIntExact(long value) {
    if ((int)value != value) {
        throw new ArithmeticException("integer overflow");
    }
    return (int)value;
}