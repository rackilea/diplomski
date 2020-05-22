// forEach
static final class ForEachMappingTask<K,V>
    extends BulkTask<K,V,Void> {
    final BiConsumer<? super K, ? super V> action;
    ForEachMappingTask
        (BulkTask<K,V,?> p, int b, int i, int f, Node<K,V>[] t,
         BiConsumer<? super K,? super V> action) {
        super(p, b, i, f, t);
        this.action = action;
    }
    public final void compute() {
        final BiConsumer<? super K, ? super V> action;
        if ((action = this.action) != null) {
            for (int i = baseIndex, f, h; batch > 0 &&
                     (h = ((f = baseLimit) + i) >>> 1) > i;) {
                addToPendingCount(1);
                new ForEachMappingTask<K,V>
                    (this, batch >>>= 1, baseLimit = h, f, tab,
                     action).fork();
            }
            for (Node<K,V> p; (p = advance()) != null; )
                action.accept(p.key, p.val);
            propagateCompletion();
        }
    }
}

// forEachEntry
static final class ForEachEntryTask<K,V>
    extends BulkTask<K,V,Void> {
    final Consumer<? super Entry<K,V>> action;
    ForEachEntryTask
        (BulkTask<K,V,?> p, int b, int i, int f, Node<K,V>[] t,
         Consumer<? super Entry<K,V>> action) {
        super(p, b, i, f, t);
        this.action = action;
    }
    public final void compute() {
        final Consumer<? super Entry<K,V>> action;
        if ((action = this.action) != null) {
            for (int i = baseIndex, f, h; batch > 0 &&
                     (h = ((f = baseLimit) + i) >>> 1) > i;) {
                addToPendingCount(1);
                new ForEachEntryTask<K,V>
                    (this, batch >>>= 1, baseLimit = h, f, tab,
                     action).fork();
            }
            for (Node<K,V> p; (p = advance()) != null; )
                action.accept(p);
            propagateCompletion();
        }
    }
}