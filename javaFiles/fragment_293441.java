public static boolean booleanFraction(int number, boolean... bools) {
    int acc = 0;
    for (boolean b : bools)
        acc += b ? 1 : 0;
    return acc == number;
}