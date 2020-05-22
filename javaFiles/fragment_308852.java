public static boolean rollType(int x, int y, int z, boolean print) {
    boolean lucky = false;
    if (x == y && y == z) {
        if (print) System.out.println("You rolled a triple");
        lucky = true;
    } else if (x == y || y == z || x == z) {
        if (print) System.out.println("You rolled a pair");
        lucky = true;
    } else {
        if (print) System.out.println("You rolled nothing");
        lucky = false;
    }
    return lucky;
}