abstract class AbstractCatalogHistory<C extends AbstractCatalog<C>> {

    public abstract Set<? extends AbstractHistoryEntry<C>> getEntries();
}

class Catalog1History extends AbstractCatalogHistory<Catalog1> {

    @Override
    public Set<Cat1HistoryEntry> getEntries() { ... }
}

class Catalog2History extends AbstractCatalogHistory<Catalog2> {

    @Override
    public Set<Cat2HistoryEntry> getEntries() { ... }
}