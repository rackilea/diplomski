public static int recursiveMultiply(int x, int y) { 
    if (y < 0) {
        return recursiveMultiply(-x, -y);
    }
    if (y == 0) {
        return 0;
    }
    System.out.print(x);
    if (y != 1) {
        System.out.print(" + ");
    }
    return x + recursiveMultiply(x, y - 1);
}