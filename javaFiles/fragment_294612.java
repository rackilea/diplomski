public class BitwiseOperatorPerformance {
    @Benchmark
    public int timeOr(int reps){
        int dummy = 0;
        for (int i = 0; i < reps; i++) {
            dummy |= i+1;
        }
        return dummy;
    }
    @Benchmark
    public int timeAnd(int reps){
        int dummy = 0;
        for (int i = 0; i < reps; i++) {
            dummy &= i+1;
        }
        return dummy;
    }
}