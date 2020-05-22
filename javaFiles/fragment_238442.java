@Param({"1", "2"})
public int arg;

@Benchmark
public int doBenchmark() {
  return doSomethingWith(arg);
}