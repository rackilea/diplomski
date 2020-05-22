public final class Fun {
    private final Object lock = new Object();

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
        // Doing things...
        synchronized (this.lock) {
            // Where we do sensitive work
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public V put(final K key, @Nullable final V value) {
        // Doing things...
        synchronized (this.lock) {
            // Where we do sensitive work
        }
        // Doing things...
    }
}