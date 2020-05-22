private static int calculate(int total, int depth) {
    if (total == 0)
        return depth;
    else {
        int i = total - 7  >= 0 ? calculate(total - 7, depth+1) : Integer.MAX_VALUE;
        int j = total - 5  >= 0 ? calculate(total - 5, depth+1) : Integer.MAX_VALUE;
        int k = total - 1  >= 0 ? calculate(total - 1, depth+1) : Integer.MAX_VALUE;
        return Collections.min(Arrays.asList(i, j, k));
    }
}