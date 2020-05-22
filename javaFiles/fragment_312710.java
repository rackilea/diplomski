default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            // `test` returns `true` for some entry
            if (filter.test(each.next())) { 
               // entry has been just changed, `test` would return `false` now
               each.remove(); // ...but we still remove
               removed = true;
            }
        }
        return removed;
    }