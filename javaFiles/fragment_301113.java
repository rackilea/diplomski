public class Specifier {
  private static final Map<String, Specifier> flyweights = new HashMap<>();

  public static final Specifier KNOWN1 = Specifier.of("1");
  public static final Specifier KNOWN2 = Specifier.of("2");
  public static final Specifier KNOWN3 = Specifier.of("3");

  static {
        flyweights.put(KNOWN1.value(), KNOWN1);
        flyweights.put(KNOWN2.value(), KNOWN2);
        flyweights.put(KNOWN3.value(), KNOWN3);
  }

  private final String value;

  public static Specifier of(String value) {
    return flyweights.computeIfAbsent(value, v -> new Specifier(value));
  }
}