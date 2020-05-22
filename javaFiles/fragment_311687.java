public class PipelineRunner {
  @Inject Injector injector; // rarely a good idea, but necessary here

  public D createD(final String inputForA) {
    Module module = new AbstractModule() {
      @Override public void configure() {
        bindConstant(inputForA).annotatedWith(PipelineInput.class);
      }
    };
    return injector.createChildInjector(new PipelineModule(), module)
        .getInstance(D.class);
  }
}