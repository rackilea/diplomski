private static long estimate(long[] n, long m, int begin, int end) {
    return (((n[end - 1] - n[begin]) / m) + 1) / 2;
}

private static long calculate(long[] n, long m, int begin, int end, long estimatedX) {
    if (m == 1) {
        return estimate(n, 1, begin, end);
    } else {
        long bestX = estimatedX;
        for (int i = begin + 1; i <= end + 1 - m; i++) {
            long firstGroupX = estimate(n, 1, begin, i);
            if (firstGroupX < bestX) {
                bestX = Math.min(bestX, Math.max(firstGroupX, calculate(n, m - 1, i, end, bestX)));
            } else {
                i = end;
            }
        }
        return bestX;
    }
}

private static long solver(long[] n, long m,  int begin, int end) {
    long estimate = estimate(n, m, begin, end);
    PriorityQueue<long[]> islands = new PriorityQueue<>((p0, p1) -> Long.compare(p1[0], p0[0]));
    int islandBegin = begin;
    for (int i = islandBegin; i < end -1; i++) {
        if (n[i + 1] - n[i] > estimate) {
            long estimatedIsland = estimate(n, 1, islandBegin, i+1);
            islands.add(new long[]{estimatedIsland, islandBegin, i, 1});
            islandBegin = i+1;
        }
    }
    long estimatedIsland = estimate(n, 1, islandBegin, end);
    islands.add(new long[]{estimatedIsland, islandBegin, end, 1});
    long result;
    if (islands.isEmpty() || m < islands.size()) {
        result = calculate(n, m, begin, end, estimate);
    } else {    
        long mFree = m - islands.size();
        while (mFree > 0) {
            long[] island = islands.poll();
            island[3]++;
            island[0] = solver(n, island[3], (int) island[1], (int) island[2]);
            islands.add(island);
            mFree--;
        }
        result = islands.poll()[0];
    }
    return result;
}

public static void main(String[] args) {
    long[] n = new long[63];
    for (int i = 1; i < n.length; i++) {
        n[i] = 2*n[i-1]+1;
    }
    long m = 32;
    Arrays.sort(n);
    System.out.println(solver(n, m, 0, n.length));
}