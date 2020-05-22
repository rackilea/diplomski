public class SolveCombination {
    public static List<Integer> solve(int c, int n) {
        int k = c / n;
        int rk = k + 1;
        int p = (c - (k * n));

        return Stream.concat(Stream.generate(() -> rk).limit(p), 
                             Stream.generate(() -> k).limit(n - p))
                     .collect(Collectors.toList());
    }
}