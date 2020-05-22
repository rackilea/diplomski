public int closest(int of, List<Integer> in) {
    int min = Integer.MAX_VALUE;
    int closest = of;

    for (int v : in) {
        final int diff = Math.abs(v - of);

        if (diff < min) {
            min = diff;
            closest = v;
        }
    }

    return closest;
}