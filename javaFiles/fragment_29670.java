// Generic method.
<R,C,V> ImmutableTable<R,C,V> filterToImmutable(Table<R,C,V> unfiltered, Predicate<Table.Cell<R,C,V>> predicate) {
  ImmutableTable.Builder<R,C,V> filtered = ImmutableTable.builder();

  // Actually, let's use some Java 8, just because we can!
  unfiltered.cells().parallelStream()
      .filter(predicate)
      .foreach(filtered::put);
  return filtered.build();
}

// Specific predicate
boolean isActiveCell(Table.Cell<MarketplaceArc, String, ObjectB> cell) {
  return isActive(cell.getRow(), cell.getValue());
}

// Use all you've written, with some Java 8, just because we can. Again.
ImmutableTable<MarketplaceArc, Map<String, ObjectB> unfiltered = ... ;
ImmutableTable<MarketplaceArc, Map<String, ObjectB> filtered = filterToImmutable(unfiltered, this::isActiveCell);