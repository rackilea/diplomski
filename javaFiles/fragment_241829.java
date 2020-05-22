public static int go(int[] ray) {
    int smallest = ray.length > 0 ? ray[0] : -1;
    for (int value : ray) {
        if (smallest > value) {
            smallest = value;
        }
    }
    return smallest;
}