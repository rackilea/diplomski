private static int estimate(int[] n, int m, int begin, int end) {
    return (((n[end - 1] - n[begin]) / m) + 1 )/2;
}

private static int calculate(int[] n, int m, int begin, int end, int estimatedX){
    if (m == 1){
        return estimate(n, 1, begin, end);
    } else {
        int bestX = estimatedX;
        for (int i = begin + 1; i <= end + 1 - m; i++) {
            // It split the problem:
            int firstGroupX = estimate(n, 1, begin, i);
            if (firstGroupX < bestX){
                bestX = Math.min(bestX, Math.max(firstGroupX, calculate(n, m-1, i, end, bestX)));
            } else {
                i = end;
            }
        }
        return bestX;
    }
}

public static void main(String[] args) {
    int[] n = {1, 3, 8, 10, 18, 20, 25};
    int m = 2;
    Arrays.sort(n);
    System.out.println(calculate(n, m, 0, n.length, estimate(n, m, 0, n.length)));
}