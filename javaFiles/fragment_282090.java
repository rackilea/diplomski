class CatalogHistory<C extends AbstractCatalog<C>> {
    public Set<HistoryEntry<C>> getEntries();
}

class HistoryEntry<C extends AbstractCatalog<C>> {
    public HistoryEntry<C> getPrior();
}