import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class IoPerformanceBenchmark {
    private static final String FILE_PATH = "test.fa";

    @Benchmark
    public int readTest() throws IOException, InterruptedException {
        clearFileCaches();
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            int value;
            while ((value = reader.read()) != -1) {
                result += value;
            }
        }
        return result;
    }

    @Benchmark
    public int readLineTest() throws IOException, InterruptedException {
        clearFileCaches();
        int result = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result += line.chars().sum();
            }
        }
        return result;
    }

    private void clearFileCaches() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("EmptyStandbyList.exe", "standbylist");
        pb.inheritIO();
        pb.start().waitFor();
    }
}