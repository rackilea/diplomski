public static int twodigit(int value) {
    while (value > 99)
        value = reduce(value);
    return value;
}
private static int reduce(int value) {
    return (value <= 9 ? 0 : reduce(value / 10) * 10 + Math.abs(value / 10 % 10 - value % 10));
}