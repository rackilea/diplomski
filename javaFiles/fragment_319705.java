@Benchmark
@BenchmarkMode(Mode.Throughput)
public List<Integer> test1() throws Exception {
    Constructor<ArrayList> constructor = ArrayList.class.getDeclaredConstructor(int.class);
    return constructor.newInstance(42);
}

@Benchmark
@BenchmarkMode(Mode.Throughput)
public List<Integer> test2() throws Exception {
    return new ArrayList(42);
}

private Constructor<ArrayList> constructor = ArrayList.class.getDeclaredConstructor(int.class);

@Benchmark
@BenchmarkMode(Mode.Throughput)
public List<Integer> test3() throws Exception {
    return constructor.newInstance(42);
}