new MapFunction<Long, Long>() {

  @Inject Lazy<MyDependency> dep;

  public Long map(Long value) {
    return dep.get().doSomething(value);
  }
}