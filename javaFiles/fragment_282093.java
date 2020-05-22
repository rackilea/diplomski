class CatalogHistory<C extends AbstractCatalog<C>> {
    public Set<HistoryEntry<C>> getEntries();
    public void addEntry(HistoryEntry<C> entry);
}

class HistoryEntry<C extends AbstractCatalog<C>> {
    public HistoryEntry<C> getPrior();
    public void setPrior(HistoryEntry<C> prior);
}