public class Test {
  public enum Kind { CLASS, FIELD, METHOD }

  public void applyMask(char kind, EnumSet<Kind> flags) {
    final EnumSet<Kind> mask;
    switch (kind) {
      case 'C': mask = EnumSet.of(Kind.CLASS);    break;
      case 'F': mask = EnumSet.of(Kind.FIELD);    break;
      case 'M': mask = EnumSet.of(Kind.METHOD);   break;
      default:  mask = EnumSet.allOf(Kind.class); break;
    }
    EnumSet<Kind> badFlags = EnumSet.copyOf(flags);
    badFlags.removeAll(mask); // See note below
    flags.retainAll(mask);
  }
}