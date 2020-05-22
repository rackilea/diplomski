@State(Scope.Thread)
  public static class ThreadState {
      volatile double x = Math.PI;
  }

  @Benchmark
  public void measureUnshared(ThreadState state) {
    state.x++;
  }