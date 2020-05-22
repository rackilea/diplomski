public static class MyService {
  private final ThreadFactory threadFactory;

  @Inject
  MyService(ThreadFactory threadFactory) {
    this.threadFactory = threadFactory;
  }

  ...
}