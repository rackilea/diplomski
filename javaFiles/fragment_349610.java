stream
    .doOnSubscribe(d -> database.beginTransaction())
    . ...
    .subscribe(v -> {...},
        e -> database.endTransaction(),
        () -> { database.setTransactionSuccessful(); database.endTransaction(); })