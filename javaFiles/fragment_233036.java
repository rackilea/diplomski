public class Magician {
  private static final ServiceLoader<MagicProvider> providers = ServiceLoader.load(MagicProvider.class);

  public static Magician getInstance() {
    for(MagicProvider provider: providers) {
      if (provider != null) {
        return new Magician(provider);
      }
    }
    throw new RuntimeException("No implementation found for MagicProvider");
  }

  private final MagicProvider provider;
  private Magician (MagicProvider provider) {
    this.provider = provider;
  }
  public Trick getTrick() {
    return provider.getTrick();
  }
}