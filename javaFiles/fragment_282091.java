abstract class AbstractHistoryEntry<C extends AbstractCatalog<C>> {

    public abstract AbstractHistoryEntry<C> getPrior();
}

class Cat1HistoryEntry extends AbstractHistoryEntry<Catalog1> {

    @Override
    public Cat1HistoryEntry getPrior() { ... }
}

class Cat2HistoryEntry extends AbstractHistoryEntry<Catalog2> {

    @Override
    public Cat2HistoryEntry getPrior() { ... }
}