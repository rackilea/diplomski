public class Copperfield implements MagicProvider {
  private final Injector injector;
  public Copperfield() {
    injector = Guice.createInjector(new CopperfieldModule());
  }
  public Trick getTrick() {
    return injector.getInstance(Trick.class);
  }
}