import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import com.carrotsearch.junitbenchmarks.BenchmarkOptionsSystemProperties;

public class Wrapper {

    public static void main(String[] args) {
        System.setProperty(BenchmarkOptionsSystemProperties.IGNORE_ANNOTATION_OPTIONS_PROPERTY, "true");
        System.setProperty(BenchmarkOptionsSystemProperties.WARMUP_ROUNDS_PROPERTY, "20");
        System.setProperty(BenchmarkOptionsSystemProperties.BENCHMARK_ROUNDS_PROPERTY, "20");

        JUnitCore junit = new JUnitCore();
        Result result = junit.run(BenchmarkTest.class);
    }
}