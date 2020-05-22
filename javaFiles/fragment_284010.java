@FunctionalInterface
  interface TwoArgumentFunction<T, K, V> {
     T doJob(K arg1, V arg2);
  } //I know I've ommited return value in that case

  public <T, K, V> T runLongAction(final TwoArgumentFunction<? extends T, ? super K, ? super V> action, final K arg1, final V arg2) {
    return action.doJob(arg1, arg2);
  }

  private void test() {
    final String a = "A";
    final Long b = 1L;
    this.runLongAction((ta, tb) -> {return 1;}, a, b);
  }