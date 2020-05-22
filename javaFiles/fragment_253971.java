public class MatcherSpliterator extends AbstractSpliterator<String[]>
{
  private final Matcher m;

  public MatcherSpliterator(Matcher m) {
    super(Long.MAX_VALUE, ORDERED | NONNULL | IMMUTABLE);
    this.m = m;
  }

  @Override public boolean tryAdvance(Consumer<? super String[]> action) {
    if (!m.find()) return false;
    final String[] groups = new String[m.groupCount()+1];
    for (int i = 0; i <= m.groupCount(); i++) groups[i] = m.group(i);
    action.accept(groups);
    return true;
  }
}