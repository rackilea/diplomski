import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1)
public class MyBenchmark {

    private List<Integer> list;

    @Setup
    public void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 5)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public Object run() {
        List<Integer> copy = new ArrayList<>();
        for (Integer item : list) {
            copy.add(item);
        }
        return copy;
    }
}