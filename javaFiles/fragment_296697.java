package bench;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class FastPow {
    @Param("3")
    int x;
    @Param({"25", "28", "31", "32"})
    int y;

    @Benchmark
    public long fast() {
        return fastPower(x, y);
    }

    @Benchmark
    public long naive() {
        return naivePower(x, y);
    }

    public static long fastPower(long x, int y) {
        long result = 1;
        while (y > 0) {
            if ((y & 1) == 0) {
                x *= x;
                y >>>= 1;
            } else {
                result *= x;
                y--;
            }
        }
        return result;
    }

    public static long naivePower(long x, int y) {
        long result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
}