import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Fork(3)
public class IndexOfTest { 
    private String str;
    private char c;
    private String s;

    @Setup
    public void setup() {
        str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        c = 'z';
        s = "z";
    }

    @Benchmark
    public int indexOfChar() {
        return str.indexOf('z');
    }

    @Benchmark
    public int indexOfString() {
        return str.indexOf("z");
    }

    @Benchmark
    public int indexOfCharIndirect() {
        return str.indexOf(c);
    }

    @Benchmark
    public int indexOfStringIndirect() {
        return str.indexOf(s);
    }
}