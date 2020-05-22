stream
    . ... // processing
    .buffer(...) // collect updates all or in batches
    .subscribe(Collection<ItemUpdate> batch -> {
            database.beginTransaction();
            try {
                ... // update multiple items
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }
        },
        e -> {...},
        () -> {...});