public static class FilterPredicate<K, V> implements Predicate<Map.Entry<K, V>> {
  private final Multimap<K, V> filterAgainst;

  public FilterPredicate(Multimap<K, V> filterAgainst) {
    this.filterAgainst = filterAgainst;
  }

  @Override
  public boolean apply(Entry<K, V> arg0) {
    return !filterAgainst.containsEntry(arg0.getKey(), arg0.getValue());
  }
}