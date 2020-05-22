public static int go(int[] ray) {
    for (int i = 0; i < ray.length; i++) {
        if (ray[i] % 2 != 0) {
            for (int j = i + 1; j < ray.length; j++) {
                if (ray[j] % 2 == 0) {
                    return j - i;
                }
            }
            break;
        }
    }
    return -1;
}