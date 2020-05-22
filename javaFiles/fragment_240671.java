public Flux<Item> observe(long id) {
        return getNew(id)
                .expand(item -> isLast(item)
                        ? getNew(item.id)
                        : Flux.empty());
    }
    /**
     * @return true if the given item is the last item emitted by getNew
     */
    private boolean isLast(Item item) {
        return // ... snip ...
    }