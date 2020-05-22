public static final void gtk_list_store_append(long /*int*/ list_store, long /*int*/ iter) {
    lock.lock();
    try {
        _gtk_list_store_append(list_store, iter);
    } finally {
        lock.unlock();
    }
}