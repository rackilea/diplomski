private static class ThreadLocalGenerateSHA1 extends
  ThreadLocal<GenerateSHA1> {

  @Override
  protected GenerateSHA1 initialValue() {
    return new GenerateSHA1();
  }

}

private static final ThreadLocalGenerateSHA1 generateSHA1 = new ThreadLocalGenerateSHA1();

...