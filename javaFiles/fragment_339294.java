import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkOptionsSystemProperties;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class BenchmarkTest {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule(BenchmarkOptionsSystemProperties.getDefaultConsumers());

    @Test
    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 1)
    public void test1() {
        int tmp = 1 + 2;
    }

}