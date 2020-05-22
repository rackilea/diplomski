ImmutableTable<MarketplaceArc, String, ObjectB> filterInactive(Table<MarketplaceArc, String, ObjectB> unfiltered) {
  ImmutableTable.Builder<MarketplaceArc, String, ObjectB> filtered = ImmutableTable.builder();
  for (Table.Cell<MarketplaceArc, String, ObjectB> cell: unfiltered.cells()) {
    if (isActive(cell.getRow(), cell.getValue())) {
      filtered.put(cell);
    }
  }
  return filtered.build();
}