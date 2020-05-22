@State(Scope.Benchmark)
public class ArrayEquals {
    @Param("100")
    int length;

    short[] s1, s2;
    char[] c1, c2;

    @Setup
    public void setup() {
        s1 = new short[length];
        s2 = new short[length];
        c1 = new char[length];
        c2 = new char[length];
    }

    @Benchmark
    public boolean chars() {
        return Arrays.equals(c1, c2);
    }

    @Benchmark
    @Fork(jvmArgsAppend = {"-XX:+UnlockDiagnosticVMOptions", "-XX:DisableIntrinsic=_equalsC"})
    public boolean charsNoIntrinsic() {
        return Arrays.equals(c1, c2);
    }

    @Benchmark
    public boolean shorts() {
        return Arrays.equals(s1, s2);
    }
}